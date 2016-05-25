package pageObjects;

import org.openqa.selenium.WebDriver;

public class AbstractPage {

	protected WebDriver driver;

	public AbstractPage(WebDriver driver) {
		this.driver = driver;
	}

	public WebDriver getDriver() {
		return driver;
	}

	public HomePage navigateToWebApp() {
		driver.navigate().to("https://www.google.com.ua/");
		return new HomePage(driver);
	}
	/*
	 * public OpenGmailRecoveryLetter openGmailPage() {
	 * driver.navigate().to("http://gmail.com/"); return new
	 * OpenGmailRecoveryLetter(driver); }
	 */
}