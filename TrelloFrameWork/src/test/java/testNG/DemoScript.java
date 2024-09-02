package testNG;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DemoScript {
	WebDriver driver;
	
	@BeforeMethod
	public void precondition() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));		
	}
	
	@AfterMethod
	public void postcondition() {
		driver.manage().window().minimize();
		driver.quit();		
	}
	
	@Test
	public void fbLogin() {
		driver.get("https://www.facebook.com/");
		driver.findElement(By.id("email")).sendKeys("saif@gmail.com");
		driver.findElement(By.id("pass")).sendKeys("12345");
		driver.findElement(By.name("login")).submit();
		
	}
	
	@Test
	public void vtigerLogin() {
		driver.get("https://demo.vtiger.com/vtigercrm/");
		driver.findElement(By.name("username")).sendKeys("admin");
		driver.findElement(By.name("password")).sendKeys("admin");
		driver.findElement(By.xpath("//button[text()='Sign in']")).submit();
		
	}
	@Test
	public void trelloLogin() {
		driver.get("https://trello.com/");
		driver.findElement(By.xpath("//div[contains(@class,'Buttonsstyles__ButtonGroup')]/a[text()='Log in']")).click();
		driver.findElement(By.id("username")).sendKeys("nagajiqa@gmail.com");
		driver.findElement(By.id("login-submit")).submit();
		driver.findElement(By.id("password")).sendKeys("Naveen@1995");
		driver.findElement(By.id("login-submit")).submit();
		
		
	}

}
