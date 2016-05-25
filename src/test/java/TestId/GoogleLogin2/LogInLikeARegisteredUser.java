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
import ru.yandex.qatools.allure.annotations.Title;

public class LogInLikeARegisteredUser {

	WebDriver driver;
	HomePage onHomePage;
	LoginPage onLoginPage;

	@Title("Valid login")
	@Test
	public void loginValid() {
		onHomePage = new HomePage(driver);
		onHomePage.navigateToWebApp();
		onLoginPage = onHomePage.clickOnButtonLogin();
		onLoginPage.setValidUserName();
		onLoginPage.pressbuttonNext();
		onLoginPage.setValidPassword();
		onLoginPage.pressbuttonSignIn();

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
