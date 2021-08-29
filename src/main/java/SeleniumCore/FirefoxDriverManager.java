package seleniumCore;

import java.net.MalformedURLException;
import java.net.URL;

import org.apache.logging.log4j.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

public class FirefoxDriverManager extends DriverManager {

	private Logger logger = LogManager.getLogger(FirefoxDriverManager.class.getName());
	
	@Override
	public void createWebDriver() {
		logger.info("Open Firefox Driver");
		System.setProperty("webdriver.gecko.driver",
				"//Users//germanmuller//eclipse-workspace//tools//webDrivers//chromedriver");
		this.driver = new FirefoxDriver();
	}
	
	@Override
	public void createRemoteWebDriver() {
		try {
			this.driver = new RemoteWebDriver(new URL("http://localhost:4446/wd/hub"), new FirefoxOptions());
		} catch (MalformedURLException malformedUrlEx) {
			malformedUrlEx.getCause().getMessage();
			malformedUrlEx.printStackTrace();
		}
	}
}
