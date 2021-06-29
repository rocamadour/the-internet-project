package Pages;

import java.util.List;
import org.apache.logging.log4j.*;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import SeleniumCore.AutomationException;

public class AddElementsPage extends TestPage {

	private WebDriver driver;
	private static Logger logger = LogManager.getLogger(AddElementsPage.class.getName());

	private By button = By.xpath("//button[@onclick = 'addElement()']");
	private By deleteButton = By.xpath("//div[@id = 'elements']/button[text() = 'Delete']");

	public AddElementsPage(WebDriver driver) {
		super(driver);

		logger.info("Add/Remove Elements Page OPEN");
		this.driver = driver;
		Assert.assertTrue((driver.findElement(By.xpath("//h3")).getText().contains("Elements")));
	}

	public void addElement() {
		logger.info("Add one Element");
		driver.findElement(button).click();
		Assert.assertTrue(driver.findElement(deleteButton).isDisplayed());
	}

	public void addElements(int times) throws AutomationException {
		logger.info("Add {} Elements", times);
		if (times < 1) {
			logger.error("Number of Elements should be higher than 0");
			throw new AutomationException("Number of Elements should be higher than 0");
		}
		for (int i = 1; i <= times; i++) {
			driver.findElement(button).click();
		}

	}

	public void deleteAllElements() {
		logger.info("Delete all delete buttons");
		List<WebElement> deletes = driver.findElements(By.xpath("//div[@id = 'elements']/button[text() = 'Delete']"));
		for (WebElement delete : deletes) {
			delete.click();
		}
		Assert.assertFalse(isElementPresent(deleteButton));
	}

}
