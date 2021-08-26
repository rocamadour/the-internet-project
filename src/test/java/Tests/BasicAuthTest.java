package Tests;

import org.apache.logging.log4j.*;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import Pages.BasicAuthPage;
import Pages.TheInternetPage;
import SeleniumCore.AutomationException;
import SeleniumCore.DriverType;
import Types.InternetLinks;

public class BasicAuthTest extends BaseTest {

	private static Logger logger = LogManager.getLogger(BasicAuthTest.class.getName());
	private BasicAuthPage basicAuth;

	@BeforeClass
	public void setUp() throws AutomationException {
		getDriver(DriverType.CHROME);
		basicAuth = new TheInternetPage(driver).openPage(InternetLinks.BASICAUTH);
	}

	@Test
	public void basicAuthentication() {
		logger.info("Open Basic Authentication Page with correct User and Password");
		basicAuth.openBasicAuthPage("admin", "admin");
	}

	@AfterClass
	public void tearDown() {
		quitWebDriver();
	}
}
