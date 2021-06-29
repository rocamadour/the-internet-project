package Pages;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TestPage {

	private WebDriver driver;
	private static Logger logger = Logger.getLogger(TestPage.class.getName());

	public TestPage(WebDriver driver) {
		this.driver = driver;
	}

	public boolean isElementPresent(By locatorKey) {
		logger.log(Level.INFO, "Validate the element is present or not");
		try {
			driver.findElement(locatorKey);
			logger.log(Level.INFO, "Element present");
			return true;
		} catch (org.openqa.selenium.NoSuchElementException e) {
			logger.log(Level.INFO, "Element NOT present");
			return false;
		}
	}
}
