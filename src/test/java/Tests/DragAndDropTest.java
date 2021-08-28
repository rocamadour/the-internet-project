package Tests;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Pages.DragAndDropPage;
import Pages.TheInternetPage;
import SeleniumCore.AutomationException;
import Types.InternetLinks;

public class DragAndDropTest extends BaseTest {

	private static Logger logger = LogManager.getLogger(DragAndDropTest.class.getName());
	private DragAndDropPage dragDrop;

	@BeforeMethod(description = "Start WebDriver and Open The Internet Page")
	public void openPage() throws AutomationException {
		dragDrop = new TheInternetPage(driver).openPage(InternetLinks.DRAGDROP);
	}

	@Test
	public void DragAndDropASquareTest() {
		logger.info("Drag and Drop Square A over Square B Test Case");
		dragDrop.dragAndDropA();
	}
	
}
