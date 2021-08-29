package tests;

import org.apache.logging.log4j.*;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pages.AddElementsPage;
import pages.TheInternetPage;
import seleniumCore.AutomationException;
import types.InternetLinks;

public class AddElementsTest extends BaseTest {

	private static Logger logger = LogManager.getLogger(AddElementsTest.class.getName());
	private AddElementsPage addElements;

	@BeforeMethod(description= "Start WebDriver and Open The Internet Page")
	public void openPage() throws AutomationException {
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
