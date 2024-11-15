package testpages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pagesBeans.PFwwf;

public class PFwwftest {
	public static WebDriver driver;
	    PFwwf pfwwf;

	    @BeforeClass
	    public void setUp() {
	       
	    	driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.get("file:///C:/Users/tprasad010/Downloads/wwf%203.html");
	        pfwwf = new PFwwf(driver);
	    }

	    @Test
	    public void testPFwwf() {
	       
	    	  pfwwf.setUserName("siva");
	          pfwwf.setPassword("admin@123");
	          pfwwf.setConfirmPassword("admin@123");
	          pfwwf.setEmail("siva@123gmail.com");
	          
	          Assert.assertEquals(pfwwf.getUn().getAttribute("value"), "siva", "Actual: " + pfwwf.getUn().getAttribute("value") + ", Expected: siva");
	          Assert.assertEquals(pfwwf.getPwd().getAttribute("value"), "admin@123", "Actual: " + pfwwf.getPwd().getAttribute("value") + ", Expected: admin@123");
	          Assert.assertEquals(pfwwf.getCpwd().getAttribute("value"), "admin@123", "Actual: " + pfwwf.getCpwd().getAttribute("value") + ", Expected: admin@123");
	          Assert.assertEquals(pfwwf.getEm().getAttribute("value"), "siva@123gmail.com", "Actual: " + pfwwf.getEm().getAttribute("value") + ", Expected: siva@123gmail.com");


	        pfwwf.clickSubmit();
	    }

	    @AfterClass
	    public void tearDown() {
	      
	        driver.quit();
	    }
	}

