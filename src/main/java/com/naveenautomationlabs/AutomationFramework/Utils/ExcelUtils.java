package com.naveenautomationlabs.AutomationFramework.Utils;

import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.naveenautomationlabs.AutomationFramework.base.TestBase;

public class ExcelUtils extends TestBase {

	public static FileInputStream fi;
	public static XSSFWorkbook wb;
	public static XSSFSheet ws;
	public static XSSFRow row;
	public static XSSFCell cell;
	
	public static int getRowCount(String file, String sheet) throws Exception {
		int rowCount;
		fi = new FileInputStream(file);
		wb = new XSSFWorkbook(fi);
		ws = wb.getSheet(sheet);
		rowCount = ws.getLastRowNum();
		wb.close();
		fi.close();
		return rowCount;
	}
	
	public static int getCellCount(String file, String sheet, int rowCnt) throws Exception {
		int cellCount;
		fi = new FileInputStream(file);
		wb = new XSSFWorkbook(fi);
		ws = wb.getSheet(sheet);
		row = ws.getRow(rowCnt);
		cellCount = row.getLastCellNum();
		wb.close();
		fi.close();
		return cellCount;
	}
	
	public static String getCellData(String file, String sheet, int rowCnt, int cellCount) throws Exception {
		String data;
		fi = new FileInputStream(file);
		wb = new XSSFWorkbook(fi);
		ws = wb.getSheet(sheet);
		row = ws.getRow(rowCnt);
		cell = row.getCell(cellCount);
		data = cell.getStringCellValue();
		wb.close();
		fi.close();
		return data;
	}
}
