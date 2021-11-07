package pages;

import org.apache.logging.log4j.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class BasicAuthPage extends TestPage {

	private static Logger logger = LogManager.getLogger(BasicAuthPage.class.getName());
	
	public BasicAuthPage(WebDriver driver) {
		super(driver);
		logger.info("Basic Auth Page OPEN");
	}
	
	public void openBasicAuthPage(String user, String pass) {
		logger.info("Open Basic Auth Page");
		driver.get("https://" + user + ":" + pass + "@the-internet.herokuapp.com/basic_auth");
		Assert.assertTrue((getElement(title).getText().contains("Basic Auth")));
		Assert.assertTrue((getElement(By.xpath("//p")).getText().contains("Congratulations!")));
	}
	 
}
