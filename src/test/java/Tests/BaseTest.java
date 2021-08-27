package Tests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;

import SeleniumCore.DriverManager;
import SeleniumCore.DriverManagerFactory;
import SeleniumCore.DriverType;

public abstract class BaseTest {

	protected WebDriver driver;
	protected DriverManager driverManager;

	public WebDriver getDriver(DriverType browser) {
		driverManager = DriverManagerFactory.getDriverManager(DriverType.CHROME);
		return driver = driverManager.getWebDriver();
	}
	
	@AfterTest(description = "Quit WebDriver")
	public void tearDown() {
		driverManager.quitWebDriver();
	}

}
