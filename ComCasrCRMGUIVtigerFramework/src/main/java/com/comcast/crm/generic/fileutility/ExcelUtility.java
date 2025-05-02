package com.comcast.crm.generic.fileutility;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtility {
public String getDataFromExcel(String sheetName, int rowNum, int cellNum) throws EncryptedDocumentException, IOException {
	FileInputStream fis = new FileInputStream("./TestData/TestScriptData.xlsx");
	Workbook wb = WorkbookFactory.create(fis);
	String data = wb.getSheet(sheetName).getRow(rowNum).getCell(cellNum).getStringCellValue();
	wb.close();
	return data;
}

public int getRowCount(String sheetName) throws EncryptedDocumentException, IOException {
	FileInputStream fis = new FileInputStream("./TestData/TestScriptData.xlsx");
	Workbook wb = WorkbookFactory.create(fis);
	int rowCount = wb.getSheet(sheetName).getLastRowNum();
	wb.close();
	return rowCount;	
}

public int getCellCount(String sheetName, int rowNum) throws EncryptedDocumentException, IOException {
	FileInputStream fis = new FileInputStream("./TestData/TestScriptData.xlsx");
	Workbook wb = WorkbookFactory.create(fis);
	int cellCount = wb.getSheet(sheetName).getRow(rowNum).getPhysicalNumberOfCells();
	return cellCount;
}

public void setDataIntoExcel(String sheetName, int rowNum, int cellNum, String data) throws EncryptedDocumentException, IOException {
	FileInputStream fis = new FileInputStream("./TestData/TestScriptData.xlsx");
	Workbook wb = WorkbookFactory.create(fis);
	wb.getSheet(sheetName).getRow(rowNum).createCell(cellNum);
	
	//Open Excel in write mode
	FileOutputStream fos = new FileOutputStream("./TestData/TestScriptData.xlsx");
	
	//Save the work book
	wb.write(fos);
	wb.close();
}
}
