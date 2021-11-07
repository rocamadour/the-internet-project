package pages;

import org.apache.logging.log4j.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import seleniumCore.AutomationException;
import types.InternetLinks;

public class TheInternetPage extends TestPage {

	private Logger logger = LogManager.getLogger(TheInternetPage.class.getName());

	private String theLink = "//li/a[@href = '%s']";
	private static final String URL = "https://the-internet.herokuapp.com/";

	public TheInternetPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		if (!driver.getCurrentUrl().endsWith(".com/"))
			driver.get(URL);
	}
	
	public TestPage openPage(InternetLinks link) throws AutomationException {
		logger.info("Open page: {}", link.getName());
		
		switch(link) {
		case ADDELEMENT:
			openLink(link.getLink());
			return new AddElementsPage(driver);
		case CHECKBOX:
			openLink(link.getLink());
			return new CheckboxPage(driver);
		case BASICAUTH:
			openLink(link.getLink());
			return new BasicAuthPage(driver);
		case DROPDOWN:
			openLink(link.getLink());
			return new DropdownPage(driver);
		case CONTEXTMENU:
			openLink(link.getLink());
			return new ContextMenuPage(driver);
		default:
			throw new AutomationException("Page is not valid");
		}
		
	}
	
	private void openLink(String link) {
		getElement(By.xpath(String.format(theLink, link))).click();
	}
}
