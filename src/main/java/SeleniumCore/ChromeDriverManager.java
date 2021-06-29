package SeleniumCore;

import org.apache.logging.log4j.*;
import org.openqa.selenium.chrome.ChromeDriver;

public class ChromeDriverManager extends DriverManager {
	
	private Logger logger = LogManager.getLogger(ChromeDriverManager.class.getName());

	@Override
	public void createWebDriver() {
		logger.info("Open Chrome Driver");
		System.setProperty("webdriver.chrome.driver",
				"//Users//germanmuller//eclipse-workspace//tools//webDrivers//chromedriver");
		this.driver = new ChromeDriver();
	}
}