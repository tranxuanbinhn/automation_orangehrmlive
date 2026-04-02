package com.orangehrmlive.helpers;

import com.orangehrmlive.utils.LogUtils;
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
    private String excelFilePath;

public void setExcelFile(String excelFile, String sheetName){
    try{
        File f = new File(excelFile);
        try{
            if(!f.exists()) {
                System.out.println("Not found file");
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        try{
            if(sheetName.isEmpty()){
                System.out.println("Not found sheetname");
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }


        if(sheetName.isEmpty()){
            System.out.println("Not found sheetname");
        }
        fis = new FileInputStream(excelFile);
        workbook = WorkbookFactory.create(fis);
        sheet = workbook.getSheet(sheetName);
        try{
            if(sheet == null){
                System.out.println("Not found sheetname");
            }
        }
        catch (Exception e){
           e.printStackTrace();
        }
        sheet.getRow(0).forEach(cell->{
            columns.put(cell.getStringCellValue(), cell.getColumnIndex());
        });
    }
    catch (Exception e)
    {
        e.printStackTrace();
    }
}
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
        // Sử dụng try-with-resources để tự động đóng file sau khi đọc xong
        try (FileInputStream fis = new FileInputStream(excelPath);
             XSSFWorkbook workbook = new XSSFWorkbook(fis)) {

            sheet = workbook.getSheet(sheetName);
            int columns = getColumns(); // Giả định hàm này lấy số cột của sheet hiện tại

            // Khởi tạo mảng 2 chiều: số hàng cần lấy x 1 cột (chứa Hashtable)
            data = new Object[(endRow - startRow) + 1][1];

            for (int i = startRow; i <= endRow; i++) {
                LogUtils.info("Ex "+ i);
                Hashtable<String, String> table = new Hashtable<>();
                for (int j = 0; j < columns; j++) {
                    // Dòng 0 thường là Header (Key), dòng i là dữ liệu (Value)
                    String key = getCellData(0, j);
                    String value = getCellData(i, j);
                    if (key != null && value != null) {
                        table.put(key, value);
                    }
                }
                data[i - startRow][0] = table;
            }
        } catch (Exception e) {
            LogUtils.error("Lỗi khi đọc file Excel: " + e.getMessage());
            e.printStackTrace();
        }
        return data;
    }
    public String getCellData(int rowNum, int colNum) {
        try {
            // Kiểm tra xem dòng có tồn tại không để tránh NullPointerException
            if (sheet.getRow(rowNum) == null) return "";

            cell = sheet.getRow(rowNum).getCell(colNum);
            if (cell == null) return ""; // Kiểm tra ô có tồn tại không

            // Dùng DataFormatter để lấy đúng định dạng hiển thị trong Excel (kể cả số, ngày tháng)
            DataFormatter formatter = new DataFormatter();
            return formatter.formatCellValue(cell);

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
