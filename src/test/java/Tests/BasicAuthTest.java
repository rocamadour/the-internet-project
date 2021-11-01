package tests;

import org.apache.logging.log4j.*;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pages.BasicAuthPage;
import pages.TheInternetPage;
import seleniumCore.AutomationException;
import types.InternetLinks;

public class BasicAuthTest extends BaseTest {

	private static Logger logger = LogManager.getLogger(BasicAuthTest.class.getName());
	private BasicAuthPage basicAuth;
	
	@BeforeTest
	public void openPage() throws AutomationException {
		basicAuth = (BasicAuthPage) new TheInternetPage(driver).openPage(InternetLinks.BASICAUTH);
	}

	@Test
	public void basicAuthentication() {
		logger.info("Open Basic Authentication Page with correct User and Password");
		basicAuth.openBasicAuthPage("admin", "admin");
	}
	
}
