package Pages;

import org.apache.logging.log4j.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class BasicAuthPage {

	private WebDriver driver;
	private static Logger logger = LogManager.getLogger(BasicAuthPage.class.getName());
	
	public BasicAuthPage(WebDriver driver) {
		logger.info("Basic Auth Page OPEN");
		this.driver = driver;
	}
	
	public void openBasicAuthPage(String user, String pass) {
		logger.info("Open Basic Auth Page");
		driver.get("https://" + user + ":" + pass + "@the-internet.herokuapp.com/basic_auth");
		Assert.assertTrue((driver.findElement(By.xpath("//h3")).getText().contains("Basic Auth")));
		Assert.assertTrue((driver.findElement(By.xpath("//p")).getText().contains("Congratulations!")));
	}
	 
}
