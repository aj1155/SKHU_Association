package me.skhu.util.Excel;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * Created by iljun on 2017-02-16.
 */
public class ExcelFileType {

    public static Workbook getWorkBook(String filePath){
        FileInputStream inputStream = null;
        try{
            inputStream = new FileInputStream(filePath);
        }catch(FileNotFoundException e){
            System.out.println(e.getMessage());
        }

        Workbook workBook = null;

        if(filePath.toUpperCase().endsWith(".XLS")){
            try{
                workBook = new HSSFWorkbook(inputStream);
            }catch(IOException e){
                throw new RuntimeException(e.getMessage(),e);
            }
        }else if(filePath.toUpperCase().endsWith(".XLSX")){
            try{
                workBook = new XSSFWorkbook(inputStream);
            }catch(IOException e){
                throw new RuntimeException(e.getMessage(),e);
            }
        }

        return workBook;
    }
}
