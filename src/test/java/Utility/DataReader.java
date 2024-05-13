package Utility;

import java.io.*;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
 
public class DataReader {
	private Workbook workbook;
    private String filePath;
 
    //Constructor 
    public DataReader(String filePath){
        this.filePath = filePath;
        this.workbook = new XSSFWorkbook();
    }
    // create the sheet
    public void createSheet(String sheetName) {
    	workbook.createSheet(sheetName);
    }

    // Write the data in the sheet 
    public void setCellData(String sheetName, int rowNumber, int cellNumber, String str){
        Sheet sheet = workbook.getSheet(sheetName);
    	Row row = sheet.getRow(rowNumber);
        if (row == null) {
            row = sheet.createRow(rowNumber);
        }
        Cell cell = row.createCell(cellNumber);
        cell.setCellValue(str);
    }

    // save the data and close the workbook
    public void closeBook()throws Exception{
    	FileOutputStream fileout = new FileOutputStream(filePath);
    	workbook.write(fileout);
    	fileout.close();
    	workbook.close();
    }
}

