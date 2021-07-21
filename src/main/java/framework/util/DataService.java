package framework.util;

import java.nio.file.Files;
import java.nio.file.Paths;

import io.restassured.path.json.JsonPath;

/**
 * 
 * @author Biswajit Sundara
 * @date 21/07/2021
 *
 */

public class DataService {

	public String filePath;
	private String filename = "appdata";
	private static JsonPath jpath;
	private String basePath;


	//This is to fetch data at testcase level
	public DataService(String pageName, String testcase){
		basePath = pageName.concat(".").concat(testcase);
		initialize();
	}

	//This is to fetch common data at page level
	public DataService(String pageName){
		basePath = pageName;
		initialize();
	}


	//This will read the data from the json file and initialize the jpath tree.
	public void initialize(){
		filePath = System.getProperty("user.dir")+"\\data\\"+filename+".json";
		try {
			String fileContents = new String (Files.readAllBytes(Paths.get(filePath)));
			jpath= new JsonPath(fileContents);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}

	//This will return the field value
	public String getStringValue(String key) {
		String val = jpath.getString(basePath.concat(".").concat(key));
		return val;
	}


}
