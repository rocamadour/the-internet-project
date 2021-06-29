package SeleniumCore;

import org.apache.logging.log4j.*;
import org.openqa.selenium.firefox.FirefoxDriver;

public class FirefoxDriverManager extends DriverManager {

	private Logger logger = LogManager.getLogger(FirefoxDriverManager.class.getName());
	
	@Override
	public void createWebDriver() {
		logger.info("Open Firefox Driver");
		System.setProperty("webdriver.gecko.driver",
				"//Users//germanmuller//eclipse-workspace//tools//webDrivers//chromedriver");
		this.driver = new FirefoxDriver();
	}
}
