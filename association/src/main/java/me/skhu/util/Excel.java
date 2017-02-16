package me.skhu.util;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.ClientAnchor;
import org.apache.poi.util.IOUtils;
import org.apache.poi.util.SystemOutLogger;
import org.apache.poi.xssf.usermodel.*;
import org.springframework.stereotype.Component;
import me.skhu.domain.dto.UserDto;
import org.springframework.web.multipart.MultipartHttpServletRequest;

@Component
public class Excel {


	public void xlsxWriter(List<UserDto> list,HttpServletResponse response) throws IOException{
		XSSFWorkbook workbook = new XSSFWorkbook();
		XSSFSheet sheet = workbook.createSheet();
		XSSFRow row = sheet.createRow(0);
		XSSFCell cell;

		for(int i=0; i<11; i++) {
			sheet.setColumnWidth(i,11*256);
		}

		cell = row.createCell(0);
		cell.setCellValue("분류");

		cell = row.createCell(1);
		cell.setCellValue("기수");

		cell = row.createCell(2);
		cell.setCellValue("사진");

		cell = row.createCell(3);
		cell.setCellValue("이름");

		cell = row.createCell(4);
		cell.setCellValue("직책");

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

			cell = row.createCell(0);
			cell.setCellValue(userDto.getCategoryName());

			cell = row.createCell(1);
			cell.setCellValue(userDto.getGrade());

			cell = row.createCell(2);
			row.setHeight((short)(10*215));
			drawImage(workbook,sheet,index,userDto);

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

	public List<UserDto> readExcel(String path, MultipartHttpServletRequest request) throws IOException{
		File file = new File(path);
		FileInputStream inputDocument = null;
		XSSFWorkbook workBook = new XSSFWorkbook();
		XSSFSheet sheet;
		XSSFRow row ;
		XSSFCell cell;
		List<UserDto> userList = new ArrayList<UserDto>();
		List<XSSFPictureData> list = workBook.getAllPictures();

		try{
			inputDocument = new FileInputStream(file);
			workBook = new XSSFWorkbook(inputDocument);
		}catch(FileNotFoundException e){
			e.printStackTrace();
		}catch(IOException e){
			e.printStackTrace();
		}

		sheet = workBook.getSheetAt(0);
		int rowSize = sheet.getLastRowNum() + 1;
		XSSFCell value;
		UserDto userDto;
		String imagePath=null;

		for(int i=0; i<rowSize; i++){
			row= sheet.getRow(i);
			if(row!=null){
				userDto = new UserDto();
				userDto.setCategoryName(row.getCell(0).toString());
				value =row.getCell(1);
				double x = Double.parseDouble(value.toString());
				int y = (int)x;
				userDto.setGrade(y);
				value = row.getCell(2);
				if(value!=null)
					imagePath = readImage(list.get(i),request);
				userDto.setImage(imagePath);
				userDto.setName(row.getCell(3).toString());
				userDto.setPositionName(row.getCell(4).toString());
				value=row.getCell(5);
				x = Double.parseDouble(value.toString());
				y = (int)x;
				userDto.setPhoneNumber(String.valueOf(y));
				value=row.getCell(6);
				x = Double.parseDouble(value.toString());
				y = (int)x;
				userDto.setCompanyNumber(String.valueOf(y));
				value=row.getCell(8);
				x = Double.parseDouble(value.toString());
				y = (int)x;
				userDto.setBirth(String.valueOf(y));
				userDto.setEmail(row.getCell(9).toString());
				userDto.setStatus(row.getCell(7).toString());
				userList.add(userDto);
			}
		}
		return userList;
	}

	public void drawImage(XSSFWorkbook workbook, XSSFSheet sheet, int row, UserDto userDto) throws IOException{
		try{
			InputStream inputStream = new FileInputStream("C:\\Users\\iljun\\IdeaProjects\\Association\\association\\src\\main\\webapp\\resources\\upload\\files\\1453204456664.jpeg");
			byte[] bytes = IOUtils.toByteArray(inputStream);
			int pictureIndex = workbook.addPicture(bytes,XSSFWorkbook.PICTURE_TYPE_JPEG);
			inputStream.close();

			XSSFCreationHelper helper = workbook.getCreationHelper();
			XSSFDrawing drawing = sheet.createDrawingPatriarch();
			XSSFClientAnchor anchor = helper.createClientAnchor();

			anchor.setCol1(2);
			anchor.setRow1(row+1);

			XSSFPicture picture = drawing.createPicture(anchor,pictureIndex);
			double x = 0.15;

			picture.resize(x);

		}catch(Exception e){
			System.out.println(e.getMessage());
		}
	}

	public String readImage(XSSFPictureData pictureData , MultipartHttpServletRequest request) throws IOException{
		byte[] bytes = pictureData.getData();
		String path = request.getSession().getServletContext().getRealPath("/resource/upload/userImage/");
		try{
			BufferedOutputStream buffStream =
					new BufferedOutputStream(new FileOutputStream(new File(path)));
			buffStream.write(bytes);
			buffStream.close();
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
		return "path";
	}
}
