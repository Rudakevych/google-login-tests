package TestId.GoogleLogin2;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import TestId.GoogleLogin2.WebDriverFactory;
import pageObjects.HomePage;
import pageObjects.LoginPage;

public class LoginAndLogout {

	WebDriver driver;
	HomePage onHomePage;
	LoginPage onLoginPage;

	@Test
	public void loginAndLogout() {
		onHomePage = new HomePage(driver);
		onHomePage.navigateToWebApp();
		onLoginPage = onHomePage.clickOnButtonLogin();
		onLoginPage.setValidUserName();
		onLoginPage.pressbuttonNext();
		onLoginPage.setValidPassword();
		onLoginPage.pressbuttonSignIn();
		onHomePage.clikUserIcon();
		onHomePage.pressButtonLogout();

		Assert.assertTrue(driver.findElement(By.xpath("//*[@id='hplogo']")).isDisplayed());

	}

	@BeforeMethod
	public void setup() {
		driver = WebDriverFactory.getInstance("firefox");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}

	@AfterMethod
	public void tearDown() {
		if (driver != null) {
			WebDriverFactory.killDriverInstance();
		}
	}

}
