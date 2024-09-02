package dataDrivenTesting;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class HardAssert {
	public static WebDriver driver;
	public static void main(String[] args) throws IOException, InterruptedException {
		
		FileInputStream file = new FileInputStream("./src/test/resource/Assertion.xlsx");
		Workbook workbook = WorkbookFactory.create(file);
		Sheet sheet = workbook.getSheet("Expected");
		
		
		FileInputStream file1 = new FileInputStream("./src/test/resource/Assertion.properties");
		Properties pobj = new Properties();
		pobj.load(file1);
		
		String browserName = pobj.getProperty("browser");
		System.out.println("browserName");
		
		if(browserName.equals("chrome")) {
			driver=new ChromeDriver();
		}
		
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		
		driver.get(pobj.getProperty("url"));

		driver.findElement(By.cssSelector("a[data-uuid='MJFtCCgVhXrVl7v9HA7EH_login']")).click();
		
		
		Assert.assertEquals(driver.getTitle(), sheet.getRow(0).getCell(1).getStringCellValue());

		WebElement emailText = driver.findElement(By.id("username"));
	        emailText.sendKeys(pobj.getProperty("email"));

	    WebElement ContinueButton = driver.findElement(By.xpath("//span[text()='Continue']"));
	        ContinueButton.submit();

		Thread.sleep(2000);
		 WebElement PasswordText = driver.findElement(By.id("password"));
		 PasswordText.sendKeys(pobj.getProperty("password")); 
		 WebElement LoginButton = driver.findElement(By.xpath("//span[text()='Log in']"));
		 LoginButton.submit();
		
		Thread.sleep(5000);
		Assert.assertEquals(driver.getTitle(), sheet.getRow(1).getCell(1).getStringCellValue());

		WebElement createBoard = driver.findElement(By.xpath("//span[text()='Create new board']"));
		createBoard.click();
		
		WebElement boardTitle = driver.findElement(By.xpath("//input[@data-testid='create-board-title-input']"));
		boardTitle.sendKeys(pobj.getProperty("boardtitle"));
		
	        WebElement boardBttn = driver.findElement(By.xpath("//button[@data-testid='create-board-submit-button']"));
	        boardBttn.click();

	        Thread.sleep(5000);

	        Assert.assertEquals(driver.getTitle(), sheet.getRow(2).getCell(1).getStringCellValue());




	}
	

}
