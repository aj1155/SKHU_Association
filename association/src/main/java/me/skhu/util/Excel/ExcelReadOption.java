package me.skhu.util.Excel;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by iljun on 2017-02-16.
 */
@Getter
@Setter
public class ExcelReadOption {

    private String filePath;

    private List<String> column;

    private int startRow;

    public List<String> getColumns() {

        List<String> temp = new ArrayList<String>();
        temp.addAll(column);

        return temp;
    }

    public void setColumns(List<String> outputColumns) {

        List<String> temp = new ArrayList<String>();
        temp.addAll(outputColumns);

        this.column = temp;
    }

    public void setColumns(String ... outputColumns) {

        if(this.column== null) {
            this.column= new ArrayList<String>();
        }

        for(String ouputColumn : outputColumns) {
            this.column.add(ouputColumn);
        }
    }
}
