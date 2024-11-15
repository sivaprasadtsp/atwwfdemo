package demo_scripts;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Regesiterdemo {
	public static WebDriver driver;
	@BeforeClass
	public void openbrowser() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("file:///C:/Users/tprasad010/Downloads/wwf%203.html");
		
	}
	
	@AfterMethod
	public void refreshPg() {
		driver.navigate().refresh();
	}
	@Test
	public void reg_succesfull () {
		driver.findElement(By.id("txtUserName")).sendKeys("Neelima");
		driver.findElement(By.name("txtPwd")).sendKeys("abc");
		driver.findElement(By.className("Format")).sendKeys("abc");
		driver.findElement(By.cssSelector("input[value='Female']")).click();
		driver.findElement(By.id("DOB")).sendKeys("11/12/2024");
		driver.findElement(By.xpath("//*[@id='txtEmail']")).sendKeys("nee@pwc.com");
		driver.findElement(By.name("cont")).sendKeys("7898909870");	
		
		Select drpCity = new Select(driver.findElement(By.name("City")));
		drpCity.selectByValue("Mum");
		drpCity.selectByIndex(2);
		drpCity.selectByVisibleText("Chennai");
		
		driver.findElement(By.cssSelector("input[value='reading']")).click();
		driver.findElement(By.cssSelector("input[value='movies']")).click();
		driver.findElement(By.name("submit")).click();
		
		Assert.assertTrue(driver.getCurrentUrl().contains("successful"));
		driver.navigate().back();		//if there are any more test cases after this tc
		
		
	}
	
	@Test (priority=1)
	public void test_title() {
		Assert.assertEquals(driver.getTitle(), "Email Registration Form");
		Assert.assertTrue(driver.getPageSource().contains("Email Registration Form"));
	}
	
	 @Test (priority=7)
	 public void test_pwdMismatch_displayAlert() {
		driver.findElement(By.name("txtPwd")).sendKeys("abc");
		driver.findElement(By.className("Format")).sendKeys("abc123");
		driver.findElement(By.className("Format")).sendKeys(Keys.TAB);
		Assert.assertEquals(driver.switchTo().alert().getText(), "Passwords donot match!");
		driver.switchTo().alert().accept();
	 }
	@AfterClass
	public void closeBrowser() {
		driver.quit();
	
	}
	
	}

