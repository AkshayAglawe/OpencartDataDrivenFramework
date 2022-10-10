package com.opencart.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Utils {

	public static int getRows(String path, int sheetNo) throws IOException {
		FileInputStream fis = new FileInputStream(path);
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		XSSFSheet sheet = wb.getSheetAt(sheetNo);
		int rows = sheet.getPhysicalNumberOfRows();
		wb.close();
		fis.close();
		return rows;

	}

	public static int getCols(String path, int cellNo) throws IOException {
		FileInputStream fis = new FileInputStream(path);
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		XSSFSheet sheet = wb.getSheetAt(cellNo);
		int cols = sheet.getRow(0).getLastCellNum();
		wb.close();
		fis.close();
		return cols;

	}
	
	public static Object[][]  getCellValues(String path,int sheetNo) throws IOException {
	 FileInputStream fis = new FileInputStream(path); 
	 XSSFWorkbook wb = new XSSFWorkbook(fis);
	  XSSFSheet sheet = wb.getSheetAt(sheetNo);       
	int rows = Utils.getRows(path, sheetNo);
	int cols = Utils.getCols(path, sheetNo);
	Object[][] loginDataset = new Object[rows-1][cols];    
	for (int i = 0; i < rows - 1; i++) {
		XSSFRow row = sheet.getRow(i + 1);

		for (int j = 0; j < cols; j++) {
			XSSFCell cell = row.getCell(j);

			switch (cell.getCellType()) {
			case STRING:
				cell.getStringCellValue();
				loginDataset[i][j] = cell.getStringCellValue();
				break;
			case NUMERIC:
				loginDataset[i][j] = cell.getNumericCellValue();
				break;
			
			}

		}

	}
	return loginDataset;
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

//	public static String getCellValue(String path, int sheetNo, int rowNo, int colNo) throws IOException {
//
//		FileInputStream fis = new FileInputStream(path);
//		XSSFWorkbook wb = new XSSFWorkbook(fis);
//		XSSFSheet sheet = wb.getSheetAt(sheetNo);
//
//		int rows = sheet.getPhysicalNumberOfRows();
//		int cols = sheet.getRow(1).getLastCellNum();
//
//		String value = null;
//		for (int i = 0; i < rows; i++) {
//			XSSFRow row = sheet.getRow(rowNo);
//			for (int j = 0; i < cols; j++) {
//				XSSFCell cell = row.getCell(colNo);
//
//				value = cell.getStringCellValue();
//				break;
//
//			}
//		}
//
//		return value;
//	}
	
}