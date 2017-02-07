package me.skhu.util;

import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import me.skhu.domain.dto.UserDto;
public class Excel {

	public void xlsxWriter(List<UserDto> list,HttpServletResponse response) throws IOException{
		XSSFWorkbook workbook = new XSSFWorkbook();
		XSSFSheet sheet = workbook.createSheet();
		XSSFRow row = sheet.createRow(0);
		XSSFCell cell;

		cell = row.createCell(0);
		cell.setCellValue("분류");

		cell = row.createCell(1);
		cell.setCellValue("기수");

		cell = row.createCell(2);
		cell.setCellValue("이름");

		cell = row.createCell(3);
		cell.setCellValue("직책");

		cell = row.createCell(4);
		cell.setCellValue("전화번호");

		cell = row.createCell(5);
		cell.setCellValue("직장 전화번호");

		cell = row.createCell(6);
		cell.setCellValue("직책");

		cell = row.createCell(7);
		cell.setCellValue("생년월일");

		cell = row.createCell(8);
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
			cell.setCellValue(userDto.getName());

			cell = row.createCell(3);
			cell.setCellValue(userDto.getPositionName());

			cell = row.createCell(4);
			cell.setCellValue(userDto.getPhoneNumber());

			cell = row.createCell(5);
			cell.setCellValue(userDto.getCompanyNumber());

			cell = row.createCell(6);
			cell.setCellValue(userDto.getStatus());

			cell = row.createCell(7);
			cell.setCellValue(userDto.getBirth());

			cell = row.createCell(8);
			cell.setCellValue(userDto.getEmail());
		}

		response.setContentType("application/vnd.ms-excel");
		response.setHeader("Content-Disposition", "attachment; fileName=association.xlsx");
		OutputStream out = new BufferedOutputStream(response.getOutputStream());
		workbook.write(out);
		response.getOutputStream().flush();
		response.getOutputStream().close();
	}
}
