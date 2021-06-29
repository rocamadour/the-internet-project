package Pages;

import org.apache.logging.log4j.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import SeleniumCore.AutomationException;
import Types.InternetLinks;

public class TheInternetPage {

	private Logger logger = LogManager.getLogger(TheInternetPage.class.getName());
	private WebDriver driver;

	private String theLink = "//li/a[@href = '%s']";

	public TheInternetPage(WebDriver driver) {
		this.driver = driver;
		driver.get("https://the-internet.herokuapp.com/");
	}
	
	@SuppressWarnings("unchecked")
	public <T> T openPage(InternetLinks link) throws AutomationException {
		logger.info("Open page: {}", link.getName());
		
		switch(link) {
		case ADDELEMENT:
			driver.findElement(By.xpath(String.format(theLink, link.getLink()))).click();
			return (T) new AddElementsPage(driver);
		case CHECKBOX:
			driver.findElement(By.xpath(String.format(theLink, link.getLink()))).click();
			return (T) new CheckboxPage(driver);
		default:
			throw new AutomationException("Page is not valid");
		}
		
	}

	public BasicAuthPage openBasicAuth() {
		logger.info("Get Basic Authentication Page");
		return new BasicAuthPage(driver);
	}
}
