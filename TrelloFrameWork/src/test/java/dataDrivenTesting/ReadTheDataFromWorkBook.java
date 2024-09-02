package dataDrivenTesting;

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

public class ReadTheDataFromWorkBook {
	static WebDriver driver;
	public static void main(String[] args) throws InterruptedException, EncryptedDocumentException, IOException {
		
		FileInputStream file = new FileInputStream("./src/test/resource/book1.xlsx");
		
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

//		driver.findElement(By.cssSelector("a[data-uuid='MJFtCCgVhXrVl7v9HA7EH_login']")).click();
//		
//		WebElement EmailText = driver.findElement(By.id("username"));
//	    EmailText.sendKeys(pobj.getProperty("email"));
//	    
//		WebElement ContinueButton = driver.findElement(By.xpath("//span[text()='Continue']"));
//		ContinueButton.submit();
//		
//		 WebElement PasswordText = driver.findElement(By.id("password"));
//		 PasswordText.sendKeys(pobj.getProperty("password"));
//		 
//		WebElement LoginButton = driver.findElement(By.xpath("//span[text()='Log in']"));
//		LoginButton.submit();
//		
//
//		WebElement CreateBoard = driver.findElement(By.xpath("//span[text()='Create new board']"));
//		wait.until(ExpectedConditions.visibilityOf(CreateBoard));
//		CreateBoard.click();
//		WebElement BoardTitle = driver.findElement(By.xpath("//input[@data-testid='create-board-title-input']"));
//		BoardTitle.sendKeys(pobj.getProperty("boardtitle"));
//		
//	WebElement BoardBttn = driver.findElement(By.xpath("//button[@data-testid='create-board-submit-button']"));
//	wait.until(ExpectedConditions.visibilityOf(BoardBttn));
//	BoardBttn.click();
//
//		Thread.sleep(6000);
//		
//		driver.switchTo().activeElement().sendKeys(pobj.getProperty("listname1"), Keys.ENTER);
//		driver.switchTo().activeElement().sendKeys(pobj.getProperty("listname2"), Keys.ENTER);
//		driver.switchTo().activeElement().sendKeys(pobj.getProperty("listname3"), Keys.ENTER);
//		driver.switchTo().activeElement().sendKeys(pobj.getProperty("listname4"), Keys.ENTER);
//		driver.switchTo().activeElement().sendKeys(pobj.getProperty("listname5"), Keys.ENTER);
//		
//		
//		WebElement Cart = driver.findElement(By.xpath("//h2[text()='skills']/../../..//button[text()='Add a card']"));
//		wait.until(ExpectedConditions.visibilityOf(Cart));
//		Cart.click();
//		Thread.sleep(2000);
//		driver.switchTo().activeElement().sendKeys(pobj.getProperty("addcard1"),Keys.ENTER);
//		driver.switchTo().activeElement().sendKeys(pobj.getProperty("addcard2"),Keys.ENTER);
//		driver.switchTo().activeElement().sendKeys(pobj.getProperty("addcard3"),Keys.ENTER);
//		driver.switchTo().activeElement().sendKeys(pobj.getProperty("addcard4"),Keys.ENTER);
//		
//
//		Actions act=new Actions(driver);
//		
//		WebElement dest1 = driver.findElement(By.xpath("//h2[text()='java']/../../..//ol[@data-testid='list-cards']"));
//		WebElement src1 = driver.findElement(By.xpath("//a[text()='oops']"));
//		act.clickAndHold(src1).pause(1000).release(dest1).perform();
//		
//
//		Thread.sleep(5000);
//		WebElement dest2 = driver.findElement(By.xpath("//h2[text()='sql']/../../..//ol[@data-testid='list-cards']"));
//		WebElement src2 = driver.findElement(By.xpath("//a[text()='query']"));
//		act.clickAndHold(src2).pause(1000).release(dest2).perform();
//		
//		
//
//		Thread.sleep(5000);
//		WebElement dest3 = driver.findElement(By.xpath("//h2[text()='automation']/../../..//button[@data-testid='list-add-card-button']"));
//		WebElement src3 = driver.findElement(By.xpath("//a[text()='selenium']"));
//		act.clickAndHold(src3).pause(1000).release(dest3).perform();
//		
//
//		Thread.sleep(5000);
//		WebElement dest4= driver.findElement(By.xpath("//h2[text()='manual']/../../..//ol[@data-testid='list-cards']"));
//		WebElement src4 = driver.findElement(By.xpath("//a[text()='bbt']"));
//		act.clickAndHold(src4).pause(1000).release(dest4).perform();
		
	}
}
