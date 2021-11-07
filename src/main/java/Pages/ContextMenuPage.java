package pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class ContextMenuPage extends TestPage {

	private Logger logger = LogManager.getLogger(ContextMenuPage.class.getName());
	private By rectangle = By.xpath("//div[@id='hot-spot']");

	public ContextMenuPage(WebDriver driver) {
		super(driver);
		logger.info("Context Menu Page OPEN");
		Assert.assertTrue((getElement(title).getText().contains("Context Menu")));
	}
	
	public void openContextMenu() {
		logger.info("Make a right click on the rectangle displayed in the page");
		openContextMenu(rectangle);
	}

}
