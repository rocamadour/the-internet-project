package seleniumCore;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

public class EdgeDriverManager extends DriverManager {

	@Override
	protected void createWebDriver() {
		EdgeOptions options = new EdgeOptions();
		this.driver = new EdgeDriver(options);
	}

	@Override
	public void createRemoteWebDriver() {
		try {
			this.driver = new RemoteWebDriver(new URL("http://localhost:4447/wd/hub"), new EdgeOptions());
		} catch (MalformedURLException malformedUrlEx) {
			malformedUrlEx.getCause().getMessage();
			malformedUrlEx.printStackTrace();
		}
	}
}
