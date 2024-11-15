package demo_scripts;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Screeshotdemo {
public static WebDriver driver;

	
	@BeforeClass
	public void openbrowser() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://en.wikipedia.org/wiki/India");
		
	
		
	}
	@Test
	public void screenshot() throws IOException {
		
		
		File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		
		File destFile = new File("./Screenshots/wiki.png");

		FileUtils.copyFile(srcFile, destFile);
	}
	@AfterClass
	public void teardown () {
		driver.close();
		
	}
}
