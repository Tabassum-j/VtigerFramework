package mock_01;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.Duration;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class WritingDataBackToExcel {
@Test
public void writingDataBackToExcel() throws EncryptedDocumentException, IOException {
	WebDriver driver = new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	driver.get("https://demoapps.qspiders.com/ui/table?scenario=1");
	FileInputStream fis = new FileInputStream("./TestData/WritingData.xlsx");
	Workbook wb = WorkbookFactory.create(fis);
	wb.getSheet("Sheet1").createRow(0).createCell(0, CellType.STRING).setCellValue("ItemName");
	wb.getSheet("Sheet1").getRow(0).createCell(1, CellType.STRING).setCellValue("Quantity");
	
	wb.getSheet("Sheet1").createRow(1).createCell(0, CellType.STRING).setCellValue("Levis Shirt");
	wb.getSheet("Sheet1").getRow(1).createCell(1, CellType.NUMERIC).setCellValue(2.0);
	
	wb.getSheet("Sheet1").createRow(2).createCell(0, CellType.STRING).setCellValue("SAMSUNG Galaxy");
	wb.getSheet("Sheet1").getRow(2).createCell(1, CellType.NUMERIC).setCellValue(4.0);
	
	wb.getSheet("Sheet1").createRow(3).createCell(0, CellType.STRING).setCellValue("APPLEIPhone");
	wb.getSheet("Sheet1").getRow(3).createCell(1, CellType.NUMERIC).setCellValue(7);
	
	wb.getSheet("Sheet1").createRow(4).createCell(0, CellType.STRING).setCellValue("HP Envy");
	wb.getSheet("Sheet1").getRow(4).createCell(1, CellType.NUMERIC).setCellValue(3);
	
	FileOutputStream fos = new FileOutputStream("./TestData/WritingData.xlsx");
	wb.write(fos);
	wb.close();
	driver.quit();
}
}
