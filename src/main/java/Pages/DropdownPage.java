package pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class DropdownPage extends TheInternetPage {

	private Logger logger = LogManager.getLogger(DropdownPage.class.getName());
	private By dropdown = By.xpath("//select[@id='dropdown']");
	String dropdownOptions = "//select[@id='dropdown']/option[@value='%s' and @selected='selected']";
	
	public DropdownPage(WebDriver driver) {
		super(driver);
		logger.info("Dropdown Page OPEN");
		Assert.assertTrue((getElement(title).getText().contains("Dropdown List")));
	}

	public void selectDropdown(String value) {
		logger.info("Select value: {}", value);
		selectDropdownValue(dropdown, value);
		validateValueSelected(value);
	}
	
	private void validateValueSelected(String value) {
		logger.info("Validate the value selected in the Dropdown is correct");
		Assert.assertTrue(getElement(By.xpath(String.format(dropdownOptions, value))).isDisplayed());
	}
	
}
