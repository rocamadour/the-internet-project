package seleniumCore;

import java.net.MalformedURLException;
import java.net.URL;

import org.apache.logging.log4j.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

public class ChromeDriverManager extends DriverManager {
	
	private Logger logger = LogManager.getLogger(ChromeDriverManager.class.getName());

	@Override
	public void createWebDriver() {
		logger.info("Open Chrome Driver");
		System.setProperty("webdriver.chrome.driver",
				"//Users//germanmuller//eclipse-workspace//tools//webDrivers//chromedriver");
		this.driver = new ChromeDriver();
	}
	
	@Override
	public void createRemoteWebDriver() {
		try {
			this.driver = new RemoteWebDriver(new URL("http://localhost:4445/wd/hub"), new ChromeOptions());
		} catch (MalformedURLException malformedUrlEx) {
			malformedUrlEx.getCause().getMessage();
			malformedUrlEx.printStackTrace();
		}
	}
}