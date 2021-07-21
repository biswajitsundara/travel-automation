package framework.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

/**
 * This will read the properties from GlobalSettings file
 * @author Biswajit Sundara
 * @date - 21/07/2021
 */

public class TestConfig {

	private static Properties prop;
	private static TestConfig instance;

	public static synchronized TestConfig getInstance () {
		if (instance == null) {
			instance = new TestConfig();
			instance.loadFile();
		}
		return instance;
	}

	private void loadFile(){

		try {
			prop = new Properties();
			FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+ "\\src\\test\\resources\\GlobalSettings.properties");
			prop.load(fis);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	private String getPropValue(String key) {
		String propVal = prop.getProperty(key);
		if(propVal == null) {
			throw new Error("Invalid Property Value "+key);
		}
		else
			return propVal;
	}

	public String getUrl() {
		return getPropValue("AppUrl");
	}

	public String getBrowser() {
		return getPropValue("browser");
	}

}
