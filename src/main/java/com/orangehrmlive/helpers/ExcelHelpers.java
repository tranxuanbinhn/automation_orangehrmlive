package com.orangehrmlive.helpers;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;

public class ExcelHelpers {
    private FileInputStream fis;
    private Sheet sheet;
    private Cell cell;
    private Workbook workbook;
    private Row row;
    private Map<String, Integer>columns = new HashMap<>();
    public int getRows(){
        try{
            return sheet.getLastRowNum();
        }
        catch (Exception e){
            System.out.println(e);
            throw e;
        }
    }
    public int getColumns(){
        try{
            row = sheet.getRow(0);
            return row.getLastCellNum();
        }
        catch (Exception e){
            System.out.println(e);
            throw e;
        }
    }


    public Object[][] getDataHashTable(String excelPath, String sheetName, int startRow, int endRow) {
        Object[][] data = null;
        try {
            File f = new File(excelPath);
            if (!f.exists()) {
                try {

                    System.out.println("Not found");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            fis = new FileInputStream(excelPath);
            workbook =new XSSFWorkbook(fis);
            sheet = workbook.getSheet(sheetName);

            int row = getRows();
            int columns = getColumns();
            data =new Object[(endRow-startRow)+1][1];
            Hashtable<String, String>table = null;
            for (int rowNums = startRow; rowNums <= endRow; rowNums++) {
                table = new Hashtable<>();
                for (int colNum = 0; colNum < columns; colNum++) {
                    table.put(getCellData(0, colNum), getCellData(rowNums, colNum));
                }
                data[rowNums - startRow][0] = table;
            }


        } catch (Exception e) {
            e.printStackTrace();
        }
        return data;

    }
    public String getCellData(int rowNum, int colNum) {
        try {
            cell = sheet.getRow(rowNum).getCell(colNum);
            String CellData = null;
            switch (cell.getCellType()) {
                case STRING:
                    CellData = cell.getStringCellValue();
                    break;
                case NUMERIC:
                    if (DateUtil.isCellDateFormatted(cell)) {
                        CellData = String.valueOf(cell.getDateCellValue());
                    } else {
                        CellData = String.valueOf((long) cell.getNumericCellValue());
                    }
                    break;
                case BOOLEAN:
                    CellData = Boolean.toString(cell.getBooleanCellValue());
                    break;
                case BLANK:
                    CellData = "";
                    break;
            }
            return CellData;
        } catch (Exception e) {
            return "";
        }
    }
    public String getCellData(int rowNum, String columnName) {
        return getCellData(rowNum, columns.get(columnName));
    }

    public String getCellData(String columnName, int rowNum) {
        return getCellData(rowNum, columns.get(columnName));
    }
}
