package tests;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pages.ContextMenuPage;
import pages.TheInternetPage;
import seleniumCore.AutomationException;
import types.InternetLinks;

public class ContextMenuTest extends BaseTest {

	private static Logger logger = LogManager.getLogger(DropdownTest.class.getName());
	private ContextMenuPage contextMenu;
	
	@BeforeTest(description = "Start WebDriver and Open The Internet Page")
	public void openPage() throws AutomationException {
		contextMenu = new TheInternetPage(driver).openPage(InternetLinks.CONTEXTMENU);
	}
	
	@Test
	public void openContextMenu() {
		logger.info("Open Context Menu");
		contextMenu.openContextMenu();
	}
}
