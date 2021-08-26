package Tests;

import org.openqa.selenium.WebDriver;

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

	public void quitWebDriver() {
		driverManager.quitWebDriver();
	}

}
