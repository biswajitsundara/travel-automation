package framework.base;

import org.openqa.selenium.WebDriver;

/**
 * 
 * @author Biswajit Sundara
 * @date 21/07/2021
 *
 */

public class DriverFactory {

	public static ThreadLocal<WebDriver> webdriver = new ThreadLocal<WebDriver>();

	public static WebDriver getDriver() {
		return webdriver.get();
	}

	public static void setWebDriver(WebDriver driver) {
		webdriver.set(driver);
	}


	public static void initialize()  {
		if(DriverFactory.getDriver()==null)
			try {
				WebDriver driver = new BrowserFactory().getBrowserDriver();
				DriverFactory.setWebDriver(driver);
			}
		catch(Exception e) {

		}
	}

	public static void quit() {
		if(DriverFactory.getDriver()!=null) {
			DriverFactory.getDriver().quit();
		}
	}

}
