package tests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;

import seleniumCore.DriverManager;
import seleniumCore.DriverManagerFactory;
import seleniumCore.DriverType;

public abstract class BaseTest {

	protected static WebDriver driver;
	protected DriverManager driverManager;

	public WebDriver getDriver(DriverType browser, String type) {
		if (driver == null) {
			driverManager = DriverManagerFactory.getDriverManager(browser);
			switch (type) {
			case "local":
				driver = driverManager.getWebDriver();
				break;
			case "remote":
				driver = driverManager.getRemoteWebDriver();
				break;
			}
		}
		return driver;
	}

	@BeforeSuite
	public void setUp() {
		getDriver(DriverType.CHROME, "local");
	}

	@AfterTest(description = "Quit WebDriver")
	public void tearDown() {
		driverManager.quitWebDriver();
	}

}
