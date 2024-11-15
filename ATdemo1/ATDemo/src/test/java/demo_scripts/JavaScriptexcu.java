package demo_scripts;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class JavaScriptexcu {
	public static WebDriver driver;

	
	@BeforeClass
	public void openbrowser() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://en.wikipedia.org/wiki/India");
		
	
		
	}
	
	@Test
	public void test_javascript () {
		JavascriptExecutor js = (JavascriptExecutor) driver;

        // Scroll down the page by 1000 pixels
        js.executeScript("window.scrollBy(0,1000)");
	}
	 @AfterClass
	    public void tearDown() {
	        // Close the browser
	        if (driver != null) {
	           // driver.quit();
	        }
}
}
