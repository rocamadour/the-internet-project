package pages;

import org.apache.logging.log4j.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import seleniumCore.AutomationException;
import types.InternetLinks;

public class TheInternetPage extends TestPage {

	private Logger logger = LogManager.getLogger(TheInternetPage.class.getName());

	private String theLink = "//li/a[@href = '%s']";

	public TheInternetPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		driver.get("https://the-internet.herokuapp.com/");
	}
	
	@SuppressWarnings("unchecked")
	public <T> T openPage(InternetLinks link) throws AutomationException {
		logger.info("Open page: {}", link.getName());
		
		switch(link) {
		case ADDELEMENT:
			openLink(link.getLink());
			return (T) new AddElementsPage(driver);
		case CHECKBOX:
			openLink(link.getLink());
			return (T) new CheckboxPage(driver);
		case BASICAUTH:
			openLink(link.getLink());
			return (T) new BasicAuthPage(driver);
		case DROPDOWN:
			openLink(link.getLink());
			return (T) new DropdownPage(driver);
		case CONTEXTMENU:
			openLink(link.getLink());
			return (T) new ContextMenuPage(driver);
		default:
			throw new AutomationException("Page is not valid");
		}
		
	}
	
	private void openLink(String link) {
		getElement(By.xpath(String.format(theLink, link))).click();
	}
}
