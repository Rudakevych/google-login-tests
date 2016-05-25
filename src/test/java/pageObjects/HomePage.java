package pageObjects;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends AbstractPage {

	public HomePage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	// == LOGIN ==

	// Button Login
	@FindBy(xpath = "//*[@id='gb_70']")
	WebElement clickLogIn;

	public LoginPage clickOnButtonLogin() {
		driver.manage().window().maximize();
		clickLogIn.click();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		return new LoginPage(driver);
	}

	// == LOGOUT ==

	// User Icon In home page
	// *[@id='gbw']/div/div/div[2]/div[4]/div[1]/a
	@FindBy(xpath = "//*[@id='gbw']/div/div/div[2]/div[4]/div[1]")
	WebElement userIcon;

	public void clikUserIcon() {
		userIcon.click();
	}

	// Press button Logout
	@FindBy(xpath = "//*[@id='signout']")
	WebElement pressLogout;

	public void pressButtonLogout() {
		pressLogout.click();
	}

}