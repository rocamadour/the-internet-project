package Tests;

import org.apache.logging.log4j.*;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import Pages.BasicAuthPage;
import Pages.TheInternetPage;
import SeleniumCore.DriverManager;
import SeleniumCore.DriverManagerFactory;
import SeleniumCore.DriverType;

public class BasicAuthTest {

	private static Logger logger = LogManager.getLogger(BasicAuthTest.class.getName());
	private DriverManager driverManager;
	private WebDriver driver;
	private TheInternetPage internet;
	private BasicAuthPage basicAuth;

	@BeforeClass
	public void setUp() {
		driverManager = DriverManagerFactory.getDriverManager(DriverType.CHROME);
		driver = driverManager.getWebDriver();
		internet = new TheInternetPage(driver);
		basicAuth = internet.openBasicAuth();
	}

	@Test
	public void basicAuthentication() {
		logger.info("Open Basic Authentication Page with correct User and Password");
		basicAuth.openBasicAuthPage("admin", "admin");
	}

	@AfterClass
	public void tearDown() {
		driverManager.quitWebDriver();
	}
}
