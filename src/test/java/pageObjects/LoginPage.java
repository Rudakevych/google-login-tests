package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends AbstractPage {

	public LoginPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	// === FIRST STEP ===

	// Enter valid LOGIN
	@FindBy(xpath = "//*[@id='Email']")
	WebElement enterValidUserName;

	public void setValidUserName() {
		enterValidUserName.sendKeys("tester10.rudakevych");
	}

	// Press button "Next"
	@FindBy(xpath = "//*[@id='next']")
	WebElement pressbuttonNext;

	public void pressbuttonNext() {
		pressbuttonNext.click();
	}

	// === SECOND STEP ===

	// Enter valid PASSWORD
	@FindBy(xpath = "//*[@id='Passwd']")
	WebElement enterValidPassword;

	public void setValidPassword() {
		enterValidPassword.sendKeys("prohasko23");
	}

	// Enter INVALID PASSWORD
	@FindBy(xpath = "//*[@id='Passwd']")
	WebElement enterInvalidPassword;

	public void setInvalidPassword() {
		enterInvalidPassword.sendKeys("23");
	}

	// Press button "Next"
	@FindBy(xpath = "//*[@id='signIn']")
	WebElement pressbuttonLogin;

	public void pressbuttonSignIn() {
		pressbuttonLogin.click();
	}

}
