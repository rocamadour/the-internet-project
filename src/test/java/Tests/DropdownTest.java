package tests;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pages.DropdownPage;
import pages.TheInternetPage;
import seleniumCore.AutomationException;
import types.InternetLinks;

public class DropdownTest extends BaseTest {

	private static Logger logger = LogManager.getLogger(DropdownTest.class.getName());
	private DropdownPage dropdown;
	
	@BeforeMethod(description = "Start WebDriver and Open The Internet Page")
	public void openPage() throws AutomationException {
		dropdown = (DropdownPage) new TheInternetPage(driver).openPage(InternetLinks.DROPDOWN);
	}
	
	@Test
	public void selectFirstValue() {
		logger.info("Select the first value of the dropdown");
		dropdown.selectDropdown("1");
	}
	
	@Test
	public void selectSecondValue() {
		logger.info("Select the second value of the dropdown");
		dropdown.selectDropdown("2");
	}

}
