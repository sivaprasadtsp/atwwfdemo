package base;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class BaseTest {
    public static WebDriver driver;
    public static ExtentReports extentreports;
    public static ExtentTest extentTest;

    @BeforeClass
    public void openBrowser(ITestContext context) {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("file:///C:/Users/tprasad010/Downloads/wwf%203.html");
        extentTest = extentreports.createTest(context.getName());
    }

    @AfterClass
    public void closeBrowser() throws InterruptedException {
        Thread.sleep(2000);
        driver.close();
    }

    @BeforeSuite
    public void initializeExtentReport() {
        ExtentSparkReporter sparkReporter = new ExtentSparkReporter("report.html");
        extentreports = new ExtentReports();
        extentreports.attachReporter(sparkReporter);
        extentreports.setSystemInfo("OS", System.getProperty("os.name"));
        extentreports.setSystemInfo("JAVA", System.getProperty("java.version"));
    }

    @AfterSuite
    public void generateReports() throws IOException {
        extentreports.flush();
        Desktop.getDesktop().browse(new File("report.html").toURI());
    }

    @AfterMethod
    public void generateTestStatus(Method m, ITestResult result) {
        if (result.getStatus() == ITestResult.FAILURE) {
            System.out.println("Capture Screenshot");
            extentTest.fail(result.getThrowable());
        } else if (result.getStatus() == ITestResult.SUCCESS) {
            extentTest.pass(m.getName() + " is passed");
        }
    }
}