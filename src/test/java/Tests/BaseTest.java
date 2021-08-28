package Tests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import SeleniumCore.DriverManager;
import SeleniumCore.DriverManagerFactory;
import SeleniumCore.DriverType;

public abstract class BaseTest {

	protected static WebDriver driver;
	protected DriverManager driverManager;

	private WebDriver getDriver(DriverType browser) {
		if(driver == null) {
			driverManager = DriverManagerFactory.getDriverManager(DriverType.CHROME);
			driver = driverManager.getWebDriver();
		}
		return driver;
	}
	
	@BeforeTest
	public void setUp() {
		getDriver(DriverType.CHROME);
	}
	
	@AfterTest(description = "Quit WebDriver")
	public void tearDown() {
		driverManager.quitWebDriver();
	}

}
