package demo_scripts;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Dataprovider_demo  {
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

    @DataProvider(name = "registrationData")
    public Object[][] registrationData() {
        return new Object[][] {
            {"Neelima", "abc", "abc", "Female", "11/12/2024", "nee@pwc.com", "7898909870", "Chennai"},
            {"Siva", "admin@123", "admin@123", "Male", "01/01/2023", "siva@123gmail.com", "9876543210", "Mumbai"}
        };
    }

    @Test(dataProvider = "registrationData")
    public void reg_succesfull(String userName, String password, String confirmPassword, String gender, String dob, String email, String contact, String city) {
        driver.findElement(By.id("txtUserName")).sendKeys(userName);
        driver.findElement(By.name("txtPwd")).sendKeys(password);
        driver.findElement(By.className("Format")).sendKeys(confirmPassword);
        driver.findElement(By.cssSelector("input[value='" + gender + "']")).click();
        driver.findElement(By.id("DOB")).sendKeys(dob);
        driver.findElement(By.xpath("//*[@id='txtEmail']")).sendKeys(email);
        driver.findElement(By.name("cont")).sendKeys(contact);

        Select drpCity = new Select(driver.findElement(By.name("City")));
        drpCity.selectByVisibleText(city);

        driver.findElement(By.cssSelector("input[value='reading']")).click();
        driver.findElement(By.cssSelector("input[value='movies']")).click();
        driver.findElement(By.name("submit")).click();

        Assert.assertTrue(driver.getCurrentUrl().contains("successful"));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        driver.navigate().back(); 
    }

    @Test(priority = 1)
    public void test_title() {
        Assert.assertEquals(driver.getTitle(), "Email Registration Form");
        Assert.assertTrue(driver.getPageSource().contains("Email Registration Form"));
    }

    @Test(priority = 7)
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
