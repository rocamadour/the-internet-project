package pages;

import java.util.List;
import org.apache.logging.log4j.*;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import seleniumCore.AutomationException;

public class AddElementsPage extends TheInternetPage {

	private static Logger logger = LogManager.getLogger(AddElementsPage.class.getName());

	private By button = By.xpath("//button[@onclick = 'addElement()']");
	private By deleteButton = By.xpath("//div[@id = 'elements']/button[text() = 'Delete']");
	private By deleteButtons = By.xpath("//div[@id = 'elements']/button[text() = 'Delete']");

	public AddElementsPage(WebDriver driver) {
		super(driver);

		logger.info("Add/Remove Elements Page OPEN");
		Assert.assertTrue((getElement(title).getText().contains("Elements")));
	}

	public void addElement() {
		logger.info("Add one Element");
		getElement(button).click();
		Assert.assertTrue(getElement(deleteButton).isDisplayed());
	}

	public void addElements(int times) throws AutomationException {
		logger.info("Add {} Elements", times);
		if (times < 1) {
			logger.error("Number of Elements should be higher than 0");
			throw new AutomationException("Number of Elements should be higher than 0");
		}
		for (int i = 1; i <= times; i++) {
			getElement(button).click();
		}

	}

	public void deleteAllElements() {
		logger.info("Delete all delete buttons");
		List<WebElement> deletes = getElements(deleteButtons);
		for (WebElement delete : deletes) {
			delete.click();
		}
		Assert.assertFalse(isElementPresent(deleteButton));
	}

}
