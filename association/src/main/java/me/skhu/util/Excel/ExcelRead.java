package me.skhu.util.Excel;

import java.io.*;
import java.nio.channels.FileChannel;
import java.nio.file.Files;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.util.IOUtils;
import org.apache.poi.util.SystemOutLogger;
import org.apache.poi.xssf.usermodel.*;
import org.springframework.stereotype.Component;
import me.skhu.domain.dto.UserDto;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import static java.nio.file.StandardCopyOption.REPLACE_EXISTING;

@Component
public class ExcelRead {

	public void xlsxWriter(List<UserDto> list,HttpServletResponse response,HttpServletRequest request) throws IOException{
		XSSFWorkbook workbook = new XSSFWorkbook();
		XSSFSheet sheet = workbook.createSheet();
		XSSFRow row = sheet.createRow(0);
		XSSFCell cell;

		for(int i=0; i<11; i++) {
			sheet.setColumnWidth(i,11*256);
		}

		cell = row.createCell(1);
		cell.setCellValue("기수");

		cell = row.createCell(2);
		cell.setCellValue("사진");

		cell = row.createCell(3);
		cell.setCellValue("이름");

		cell = row.createCell(4);
		cell.setCellValue("동문회 직책");

		cell = row.createCell(5);
		cell.setCellValue("전화번호");

		cell = row.createCell(6);
		cell.setCellValue("직장 전화번호");

		cell = row.createCell(7);
		cell.setCellValue("직책");

		cell = row.createCell(8);
		cell.setCellValue("생년월일");

		cell = row.createCell(9);
		cell.setCellValue("이메일");

		UserDto userDto;
		for(int index=0; index<list.size(); index++){
			userDto = list.get(index);

			row = sheet.createRow(index+1);

			cell = row.createCell(1);
			cell.setCellValue(userDto.getGrade());

			cell = row.createCell(2);
			row.setHeight((short)(5*215));
			if(userDto.getImage()!=null)
				drawImage(workbook,sheet,index,userDto,request);

			cell = row.createCell(3);
			cell.setCellValue(userDto.getName());

			cell = row.createCell(4);
			cell.setCellValue(userDto.getPositionName());

			cell = row.createCell(5);
			cell.setCellValue(userDto.getPhoneNumber());

			cell = row.createCell(6);
			cell.setCellValue(userDto.getCompanyNumber());

			cell = row.createCell(7);
			cell.setCellValue(userDto.getStatus());

			cell = row.createCell(8);
			cell.setCellValue(userDto.getBirth());

			cell = row.createCell(9);
			cell.setCellValue(userDto.getEmail());
		}

		response.setContentType("application/vnd.ms-excel");
		response.setHeader("Content-Disposition", "attachment; fileName=association.xlsx");
		OutputStream out = new BufferedOutputStream(response.getOutputStream());
		workbook.write(out);
		response.getOutputStream().flush();
		response.getOutputStream().close();
	}

	public void drawImage(XSSFWorkbook workbook, XSSFSheet sheet, int row, UserDto userDto, HttpServletRequest request) throws IOException{
		try{
		    String path2 = userDto.getImage();
		    String path1 = request.getSession().getServletContext().getRealPath("/");
			InputStream inputStream = new FileInputStream(path1+path2);
			byte[] bytes = IOUtils.toByteArray(inputStream);
			int pictureIndex = workbook.addPicture(bytes,XSSFWorkbook.PICTURE_TYPE_JPEG);
			inputStream.close();

			XSSFCreationHelper helper = workbook.getCreationHelper();
			XSSFDrawing drawing = sheet.createDrawingPatriarch();
			XSSFClientAnchor anchor = helper.createClientAnchor();

			anchor.setCol1(2);
			anchor.setRow1(row+1);

			XSSFPicture picture = drawing.createPicture(anchor,pictureIndex);
			double x = 0.75;

			picture.resize(x);

		}catch(Exception e){
			System.out.println(e.getMessage());
		}
	}

	public static List<Map<String,String>> readExcel(ExcelReadOption readOption, String filePath)throws FileNotFoundException, IOException{
		Workbook workbook = ExcelFileType.getWorkBook(filePath);

		Sheet sheet = workbook.getSheetAt(0);

		int rowNum = sheet.getPhysicalNumberOfRows();
		int cellNum = 0;

		Row row = null;
		Cell cell = null;

		String cellName;

		Map<String,String> map = null;

		List<Map<String,String>> userList = new ArrayList<Map<String,String>>();

		for(int i=1; i < rowNum; i++){
			row = sheet.getRow(i);

			if(row!=null){
				cellNum = row.getPhysicalNumberOfCells();
				System.out.println("CellNum : " + cellNum);
				map = new HashMap<String,String>();

				for(int j=1; j < 11; j++){
					cell = row.getCell(j);
					cellName = ExcelCellRef.getName(cell,j);
					if(!readOption.getColumn().contains(cellName)){
						continue;
					}
					map.put(cellName, ExcelCellRef.getValue(cell));
				}
				userList.add(map);
			}
	}
		readImage(userList,workbook,filePath,sheet);
		return userList;
	}

	public static void readImage(List<Map<String, String>> result,Workbook workbook,String path,Sheet sheet) throws FileNotFoundException, IOException{
		XSSFDrawing drawing = (XSSFDrawing)sheet.createDrawingPatriarch();
		for(XSSFShape shape : drawing.getShapes()){
			if (shape instanceof XSSFPicture) {
				XSSFPicture picture = (XSSFPicture) shape;
				XSSFPictureData xssfPictureData = picture.getPictureData();
				ClientAnchor anchor = (ClientAnchor) picture.getAnchor();
				int row2 = anchor.getRow2();
				byte[] data = xssfPictureData.getData();
				String ext = xssfPictureData.suggestFileExtension();
				String fileName=result.get(row2-2).get("E");

				try (FileOutputStream os = new FileOutputStream(path+fileName+"."+ext)) {
					os.write(data);
					os.flush();
				}
                String[] arg = new String(path).split("webapp");
                System.out.println(arg[1]);
                String newPath = arg[1]+fileName+"."+ext;
                System.out.println(newPath);
                System.out.println(result.get(row2-2).replace("D",newPath));
			}
		}
	}
}
