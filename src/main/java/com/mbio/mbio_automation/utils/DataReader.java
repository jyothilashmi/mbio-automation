package com.mbio.mbio_automation.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.management.RuntimeErrorException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class DataReader {

	private static final String TESTDATA_PATH =System.getProperty("user.dir") +"src/resources/testdata.xlsx";
	
	 public static Object[][] readData(String sheetName) {
	        try {
	            String path = TESTDATA_PATH;
	            FileInputStream fis = new FileInputStream(path);
	            Workbook workbook = new XSSFWorkbook(fis);
	            Sheet sheet = workbook.getSheet(sheetName);

	            int rowCount = sheet.getPhysicalNumberOfRows();
	            int colCount = sheet.getRow(0).getPhysicalNumberOfCells();

	            Object[][] data = new Object[rowCount - 1][colCount];

	            for (int i = 1; i < rowCount; i++) {
	                Row row = sheet.getRow(i);
	                for (int j = 0; j < colCount; j++) {
	                    Cell cell = row.getCell(j);

	                    if (cell == null) {
	                        data[i - 1][j] = "";
	                        continue;
	                    }

	                    switch (cell.getCellType()) {
	                        case STRING:
	                            data[i - 1][j] = cell.getStringCellValue();
	                            break;
	                        case NUMERIC:
	                            data[i - 1][j] = cell.getNumericCellValue();
	                            break;
	                        case BOOLEAN:
	                            data[i - 1][j] = cell.getBooleanCellValue();
	                            break;
	                        default:
	                            data[i - 1][j] = "";
	                    }
	                }
	            }

	            workbook.close();
	            fis.close();
	            return data;

	        } catch (Exception e) {
	            System.out.println("Excel read error: " + e.getMessage());
	            return new Object[0][0];
	        }
	    }
}
