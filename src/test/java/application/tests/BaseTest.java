package application.tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import framework.base.DriverFactory;

/**
 * 
 * @author Biswajit Sundara
 * @date 21/07/2021
 *
 */
public class BaseTest {

	@BeforeMethod
	public void setup(){
		DriverFactory.initialize();
	}

	
	@AfterMethod
	public void teardown(){
		DriverFactory.quit();
	}

}
