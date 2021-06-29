package Tests;

import org.apache.logging.log4j.*;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import Pages.AddElementsPage;
import Pages.TheInternetPage;
import SeleniumCore.AutomationException;
import SeleniumCore.DriverManager;
import SeleniumCore.DriverManagerFactory;
import SeleniumCore.DriverType;
import Types.InternetLinks;

public class AddElementsTest {

	private static Logger logger = LogManager.getLogger(AddElementsTest.class.getName());
	private DriverManager driverManager;
	private WebDriver driver;
	private TheInternetPage internet;
	private AddElementsPage addElements;

	@BeforeClass(description= "Start WebDriver and Open The Internet Page")
	public void setUp() throws AutomationException {
		driverManager = DriverManagerFactory.getDriverManager(DriverType.CHROME);
		driver = driverManager.getWebDriver();
		internet = new TheInternetPage(driver);
		addElements = internet.openPage(InternetLinks.ADDELEMENT);
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

	@AfterClass(description= "Quit WebDriver")
	public void tearDown() {
		driverManager.quitWebDriver();
	}
}
