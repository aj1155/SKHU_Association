package me.skhu.util.Excel;

import org.apache.poi.hssf.util.CellReference;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;

import java.text.SimpleDateFormat;

/**
 * Created by iljun on 2017-02-16.
 */
public class ExcelCellRef {
    public static String getName(Cell cell, int cellNum){
        int cellNumber;
        if(cell!=null){
            cellNumber = cell.getColumnIndex();
        }else
            cellNumber = cellNum;
        return CellReference.convertNumToColString(cellNum);
    }

    public static String getValue(Cell cell){
        String value;

        if(cell==null) {
            value = "";
        }else{
            try{
                if(DateUtil.isCellDateFormatted(cell)){
                    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyMMdd");
                    value = simpleDateFormat.format(cell.getDateCellValue());
                    return value;
                }
            }catch (Exception e){
                System.out.println(e.getMessage());
            }

            switch(cell.getCellType()){
                case Cell.CELL_TYPE_FORMULA :
                    value = cell.getCellFormula();
                    break;
                case Cell.CELL_TYPE_NUMERIC :
                    value = cell.getNumericCellValue() + "";
                    break;
                case Cell.CELL_TYPE_STRING :
                    value = cell.getStringCellValue();
                    break;
                case Cell.CELL_TYPE_BOOLEAN :
                    value = cell.getBooleanCellValue() + "";
                    break;
                case Cell.CELL_TYPE_ERROR :
                    value = cell.getErrorCellValue() + "";
                    break;
                case Cell.CELL_TYPE_BLANK :
                    value = "";
                    break;
                default :
                    value = cell.getStringCellValue();
                    break;
            }
        }
        return value;

    }
}
