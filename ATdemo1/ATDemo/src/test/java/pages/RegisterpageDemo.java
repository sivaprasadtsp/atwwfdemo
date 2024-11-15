package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisterpageDemo {
	WebDriver driver;

    @FindBy(id = "txtUserName")
    @CacheLookup
    private WebElement un;

    @FindBy(name = "txtPwd")
    @CacheLookup
    private WebElement pwd;

    @FindBy(className = "Format")
    @CacheLookup
    private WebElement cpwd;

    @FindBy(xpath = "//*[@id='txtEmail']")
    @CacheLookup
    private WebElement em;

    @FindBy(name = "submit")
    @CacheLookup
    private WebElement btn;

    public RegisterpageDemo(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // Getter methods
    public WebElement getUn() {
        return un;
    }

    public WebElement getPwd() {
        return pwd;
    }

    public WebElement getCpwd() {
        return cpwd;
    }

    public WebElement getEm() {
        return em;
    }

    public WebElement getBtn() {
        return btn;
    }

    // Setter methods
    public void setUserName(String userName) {
        un.sendKeys(userName);
    }

    public void setPassword(String password) {
        pwd.sendKeys(password);
    }

    public void setConfirmPassword(String confirmPassword) {
        cpwd.sendKeys(confirmPassword);
    }

    public void setEmail(String email) {
        em.sendKeys(email);
    }

    public void clickSubmit() {
        btn.click();
    }
}