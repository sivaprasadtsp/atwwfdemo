package testpages;
import java.io.IOException;
import java.time.Duration;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import base.BaseTest;
import dataprovider.XlS_dataprovider;
import pages.RegisterpageDemo;
public class RegisterPageTest extends BaseTest {
	 WebDriver driver;
	    RegisterpageDemo registerPage;
	    WebDriverWait wait;

	    @BeforeClass
	    public void setUp() {
	        driver = new ChromeDriver();
	        driver.manage().window().maximize();
	        driver.get("file:///C:/Users/tprasad010/Downloads/wwf%203.html");
	        registerPage = new RegisterpageDemo(driver);
	        wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // 10 seconds wait
	    }

	    @AfterClass
	    public void tearDown() {
	        driver.quit();
	    }

	    @DataProvider(name = "registrationData")
	    public Object[][] getRegistrationData() throws EncryptedDocumentException, IOException {
	        return XlS_dataprovider.getTestData("Sheet1");
	    }

	    @Test(dataProvider = "registrationData")
	    public void testRegistration(String userName, String password, String confirmPassword, String email) {
	        retryingFindClick(registerPage.getUn(), userName);
	        retryingFindClick(registerPage.getPwd(), password);
	        retryingFindClick(registerPage.getCpwd(), confirmPassword);
	        retryingFindClick(registerPage.getEm(), email);
	        retryingFindClick(registerPage.getBtn(), null);

	    }

	    public void retryingFindClick(WebElement element, String value) {
	        int attempts = 0;
	        while (attempts < 3) {
	            try {
	                wait.until(ExpectedConditions.visibilityOf(element));
	                if (value != null) {
	                    element.sendKeys(value);
	                } else {
	                    element.click();
	                }
	                break;
	            } catch (StaleElementReferenceException e) {
	                attempts++;
	            }
	        }
	    }
	}