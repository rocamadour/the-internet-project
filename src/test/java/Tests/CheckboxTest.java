package Tests;

import org.apache.logging.log4j.*;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import Pages.CheckboxPage;
import Pages.TheInternetPage;
import SeleniumCore.AutomationException;
import SeleniumCore.DriverType;
import Types.InternetLinks;

public class CheckboxTest extends BaseTest {

	private static Logger logger = LogManager.getLogger(CheckboxTest.class.getName());
	private CheckboxPage checkboxPage;

	@BeforeClass(description = "Start WebDriver and Open The Internet Page")
	public void setUp() throws AutomationException {
		getDriver(DriverType.CHROME);
		checkboxPage = new TheInternetPage(driver).openPage(InternetLinks.CHECKBOX);
	}

	@Test
	public void checkFirst() {
		logger.info("Check First Checkbox Test");
		checkboxPage.checkFirst();
	}

	@Test
	public void checkSecond() {
		logger.info("Check Second Checkbox Test");
		checkboxPage.checkSecond();
	}

	@Test
	public void uncheckFirst() {
		logger.info("Uncheck First Checkbox Test");
		checkboxPage.checkFirst();
		checkboxPage.uncheckFirst();
	}

	@Test
	public void uncheckSecond() {
		logger.info("Uncheck Second Checkbox Test");
		checkboxPage.checkSecond();
		checkboxPage.uncheckSecond();
	}

}
