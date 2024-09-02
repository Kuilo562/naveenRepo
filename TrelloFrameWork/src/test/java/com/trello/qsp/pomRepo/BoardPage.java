package com.trello.qsp.pomRepo;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BoardPage {
	public static class ReadTheDataFromWorkBook {
	
			static WebDriver driver;
		
			public static void main(String[] args) throws InterruptedException, EncryptedDocumentException, IOException {
			FileInputStream file = new FileInputStream("./src/test/resource/DDT.xlsx");
			
			Workbook workbook = WorkbookFactory.create(file);
			Sheet sheet = workbook.getSheet("keyvalue");
			
			String browsername = sheet.getRow(2).getCell(1).getStringCellValue();
			System.out.println(browsername);
			
			
			if(browsername.equals("chrome")) {
				 driver = new ChromeDriver();
			}
			
			driver.manage().window().maximize();
			
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
			WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(15));
			
			driver.get(sheet.getRow(3).getCell(1).getStringCellValue());
			
			
		}
	}
}
