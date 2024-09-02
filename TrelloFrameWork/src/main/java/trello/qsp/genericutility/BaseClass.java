package trello.qsp.genericutility;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseClass {
	public WebDriver driver;
	public WebDriverUtility webdriverutils = new WebDriverUtility();
	public FileUtility fileutils = new FileUtility();
	public ExcelUtility excelutils = new ExcelUtility();
	public JavaUtility javautils = new JavaUtility();
	
	@BeforeMethod
	public void precondition() throws IOException {
	
	String browserName = fileutils.readTheDataFromPropertyFile("browser");
		if(browserName.equals("Chrome")) {
			driver = new ChromeDriver();
		}
		else if(browserName.equals("edge")) {
			driver = new EdgeDriver();
		}
		driver.manage().window().maximize();
		webdriverutils.implicitWait(driver);
		driver.get(fileutils.readTheDataFromPropertyFile("url"));		
	}
	
	@AfterMethod
	public void postCondition() {
		driver.manage().window().minimize();
	}
	
}
