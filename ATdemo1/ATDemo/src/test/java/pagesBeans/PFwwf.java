package pagesBeans;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PFwwf {
	 WebDriver driver;
	
	@FindBy(id="txtUserName")
	@CacheLookup
	private
	WebElement un;
	
	@FindBy(name="txtPwd")
	@CacheLookup
	private
	WebElement pwd;
	
	@FindBy(className="Format")
	@CacheLookup
	private
	WebElement cpwd;
	
	@FindBy(xpath="//*[@id='txtEmail']")
	@CacheLookup
	private
	WebElement em;
	
	@FindBy(name="submit")
	@CacheLookup
	WebElement btn;
	
	public PFwwf(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	// Setter methods
    public void setUserName(String userName) {
        getUn().sendKeys(userName);
    }

    public void setPassword(String password) {
        getPwd().sendKeys(password);
    }

    public void setConfirmPassword(String confirmPassword) {
        getCpwd().sendKeys(confirmPassword);
    }

    public void setEmail(String email) {
        getEm().sendKeys(email);
    }

    public void clickSubmit() {
        btn.click();
    }

	public WebElement getUn() {
		return un;
	}

	public void setUn(WebElement un) {
		this.un = un;
	}

	public WebElement getPwd() {
		return pwd;
	}

	public void setPwd(WebElement pwd) {
		this.pwd = pwd;
	}

	public WebElement getCpwd() {
		return cpwd;
	}

	public void setCpwd(WebElement cpwd) {
		this.cpwd = cpwd;
	}

	public WebElement getEm() {
		return em;
	}

	public void setEm(WebElement em) {
		this.em = em;
	}
}

