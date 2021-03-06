package pages;

import java.util.List;
import java.util.logging.Logger;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class TestPage {

	protected WebDriver driver;
	private static Logger logger = Logger.getLogger(TestPage.class.getName());

	public TestPage(WebDriver driver) {
		this.driver = driver;
	}
	
	protected By title = By.xpath("//h3");

	public WebElement getElement(By selector) {
		return driver.findElement(selector);
	}

	public List<WebElement> getElements(By selector) {
		return driver.findElements(selector);
	}

	public boolean isElementPresent(By locatorKey) {
		logger.info("Validate the element is present or not");
		try {
			getElement(locatorKey);
			logger.info("Element present");
			return true;
		} catch (org.openqa.selenium.NoSuchElementException e) {
			logger.info("Element NOT present");
			return false;
		}
	}

	@Deprecated
	public void dragAndDrop(By source, By target) {
		Actions dragDrop = new Actions(driver);
		dragDrop.dragAndDrop(getElement(source), getElement(target)).pause(1000).build().perform();
	}

	public void selectDropdownValue(By dropdownSelector, String value) {
		Select dropdown = new Select(getElement(dropdownSelector));
		dropdown.selectByValue(value);
		logger.info("Selected value is: " + dropdown.getFirstSelectedOption().getText());
	}

	public void openContextMenu(By target) {
		Actions rightClick = new Actions(driver);
		rightClick.contextClick(getElement(target)).sendKeys(Keys.RETURN).build().perform();
	}
}
