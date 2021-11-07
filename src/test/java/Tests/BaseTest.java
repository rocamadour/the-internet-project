package tests;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
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
		DriverType driverType = null;

		switch (getBrowserProperty()) {
		case "firefox":
			driverType = DriverType.CHROME;
			break;
		case "edge":
			driverType = DriverType.EDGE;
			break;
		default:
			driverType = DriverType.CHROME;
		};

		getDriver(driverType, getEnvironmentProperty());
	}

	@AfterTest(description = "Quit WebDriver")
	public void tearDown() {
		driverManager.quitWebDriver();
	}

	@AfterMethod
	public void takeScreenshotOnFailure(ITestResult testResult) throws IOException {
		if (testResult.getStatus() == ITestResult.FAILURE)
			driverManager.takeScreenShot(testResult.getName());
	}

	private String getBrowserProperty() {
		String browserName = System.getProperty("browser");
		if (browserName == null)
			browserName = "chrome";
		return browserName;
	}

	private String getEnvironmentProperty() {
		String environment = System.getProperty("env");
		if (environment == null || environment.equalsIgnoreCase("local"))
			environment = "local";
		else
			environment = "remote";
		return environment;
	}

}
