package seleniumCore;

public class DriverManagerFactory {
	
	private DriverManagerFactory() {
		throw new IllegalStateException("Utility class");
	}

	public static DriverManager getDriverManager(DriverType type) {
		DriverManager driverManager;
		switch (type) {
		case CHROME:
			driverManager = new ChromeDriverManager();
			break;
		case FIREFOX:
			driverManager = new FirefoxDriverManager();
			break;
		default:
			driverManager = new EdgeDriverManager();
			break;
		}

		return driverManager;
	}
	 
}
