package Tests;

import org.apache.logging.log4j.*;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Pages.BasicAuthPage;
import Pages.TheInternetPage;
import SeleniumCore.AutomationException;
import Types.InternetLinks;

public class BasicAuthTest extends BaseTest {

	private static Logger logger = LogManager.getLogger(BasicAuthTest.class.getName());
	private BasicAuthPage basicAuth;
	
	@BeforeMethod
	public void openPage() throws AutomationException {
		basicAuth = new TheInternetPage(driver).openPage(InternetLinks.BASICAUTH);
	}

	@Test
	public void basicAuthentication() {
		logger.info("Open Basic Authentication Page with correct User and Password");
		basicAuth.openBasicAuthPage("admin", "admin");
	}
	
}
