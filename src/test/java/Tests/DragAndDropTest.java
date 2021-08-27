package Tests;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import Pages.DragAndDropPage;
import Pages.TheInternetPage;
import SeleniumCore.AutomationException;
import SeleniumCore.DriverType;
import Types.InternetLinks;

public class DragAndDropTest extends BaseTest {

	private static Logger logger = LogManager.getLogger(DragAndDropTest.class.getName());
	private DragAndDropPage dragDrop;

	@BeforeClass(description = "Start WebDriver and Open The Internet Page")
	public void setUp() throws AutomationException {
		getDriver(DriverType.CHROME);
		dragDrop = new TheInternetPage(driver).openPage(InternetLinks.DRAGDROP);
	}

	@Test
	public void DragAndDropASquareTest() {
		logger.info("Drag and Drop Square A over Square B Test Case");
		dragDrop.dragAndDropA();
	}
	
}
