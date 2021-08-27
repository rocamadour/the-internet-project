package Tests;

import org.apache.logging.log4j.*;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import Pages.AddElementsPage;
import Pages.TheInternetPage;
import SeleniumCore.AutomationException;
import SeleniumCore.DriverType;
import Types.InternetLinks;

public class AddElementsTest extends BaseTest {

	private static Logger logger = LogManager.getLogger(AddElementsTest.class.getName());
	private AddElementsPage addElements;

	@BeforeClass(description= "Start WebDriver and Open The Internet Page")
	public void setUp() throws AutomationException {
		getDriver(DriverType.CHROME);
		addElements = new TheInternetPage(driver).openPage(InternetLinks.ADDELEMENT);
	}

	@Test
	public void addElement() {
		logger.info("Add Element Test Case");
		addElements.addElement();
	}

	@Test
	public void addRemoveElement() {
		logger.info("Add Element and Remove it Test Case");
		addElements.addElement();
		addElements.deleteAllElements();
	}

	@Test
	public void addSeveralElements() throws Exception {
		logger.info("Add several elements Test Case");
		addElements.addElements(5);
		addElements.deleteAllElements();
	}
}
