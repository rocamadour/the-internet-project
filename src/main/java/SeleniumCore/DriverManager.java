package SeleniumCore;

import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.*;
import org.openqa.selenium.WebDriver;

public abstract class DriverManager {

	protected WebDriver driver;
	private Logger logger = LogManager.getLogger(DriverManager.class.getName());

	protected abstract void createWebDriver();

	public void quitWebDriver() {
		if (null != driver) {
			logger.info("Close Browser");
			driver.quit();
			driver = null;
		}
	}

	public WebDriver getWebDriver() {
		if (null == driver) {
			logger.info("Open Browser");
			createWebDriver();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		}
		return driver;
	}
}
