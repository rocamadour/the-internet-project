package seleniumCore;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.*;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public abstract class DriverManager {

	protected WebDriver driver;
	private Logger logger = LogManager.getLogger(DriverManager.class.getName());

	protected abstract void createWebDriver();

	protected abstract void createRemoteWebDriver();

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

	public WebDriver getRemoteWebDriver() {
		if (null == driver) {
			logger.info("Open Remote Browser");
			createRemoteWebDriver();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		}
		return driver;
	}

	public void takeScreenShot(String fileName) throws IOException {
		logger.info("Take screenshot of failed test");
		File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String path = System.getProperty("user.dir") + "//tempFiles//screenshots//" + fileName + ".png";
		FileUtils.copyFile(src,	new File(path));
		logger.info("The file is located in: {}", path);
	}

}
