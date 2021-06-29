package Pages;

import org.apache.logging.log4j.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class CheckboxPage extends TestPage {

	private WebDriver driver;
	private Logger logger = LogManager.getLogger(CheckboxPage.class.getName());

	public CheckboxPage(WebDriver driver) {
		super(driver);
		logger.info("Checkboxes Page OPEN");
		this.driver = driver;
		Assert.assertTrue((driver.findElement(By.xpath("//h3")).getText().contains("Checkboxes")));
	}

	private By checkboxOne = By.xpath("//input[1]");
	private By checkboxTwo = By.xpath("//input[2]");

	public void checkFirst() {
		logger.info("Check First Checkbox");
		if (!driver.findElement(checkboxOne).isSelected()) {
			driver.findElement(checkboxOne).click();
			validateCheckbox(1, true);
		}
	}

	public void checkSecond() {
		logger.info("Check Second Checkbox");
		if (!driver.findElement(checkboxTwo).isSelected()) {
			driver.findElement(checkboxTwo).click();
			validateCheckbox(2, true);
		}
	}

	public void uncheckFirst() {
		logger.info("Uncheck First Checkbox");
		if (driver.findElement(checkboxOne).isSelected()) {
			driver.findElement(checkboxOne).click();
			validateCheckbox(1, false);
		}
	}

	public void uncheckSecond() {
		logger.info("Uncheck second checkbox");
		if (driver.findElement(checkboxTwo).isSelected()) {
			driver.findElement(checkboxTwo).click();
			validateCheckbox(2, false);
		}
	}

	private void validateCheckbox(int number, boolean isChecked) {
		logger.info("Verify the checkbox: {} is checked", number);
		if (number == 1 && isChecked)
			Assert.assertTrue(driver.findElement(checkboxOne).isSelected());
		else if (number == 1 && !isChecked)
			Assert.assertFalse(driver.findElement(checkboxOne).isSelected());
		else if (number == 2 && isChecked)
			Assert.assertTrue(driver.findElement(checkboxTwo).isSelected());
		else if (number == 2 && !isChecked)
			Assert.assertFalse(driver.findElement(checkboxTwo).isSelected());
	}

}
