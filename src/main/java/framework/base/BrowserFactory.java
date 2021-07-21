package framework.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import framework.util.TestConfig;

/**
 * 
 * @author Biswajit Sundara
 * @date 21/07/2021
 *
 */
public class BrowserFactory {

	private WebDriver driver=null;

	public WebDriver getBrowserDriver() {

		switch(TestConfig.getInstance().getBrowser()) {

		case "chrome": System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		driver = new ChromeDriver(); 
		break;

		case "firefox": System.setProperty("webdriver.gecko.driver", "./drivers/gecko.exe");
		driver = new FirefoxDriver(); 
		break;

		default: throw new Error("Invalid browser driver is set");
		}

		driver.get(TestConfig.getInstance().getUrl());
		driver.manage().window().maximize();
		return driver;
	}
}
