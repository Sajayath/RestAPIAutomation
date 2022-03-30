package resources;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Properties;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Utils 
{
	public static RequestSpecification req;
	// Note: Here RequestSpecification is static to store/remember added data in log files instead of making NULL for every Run Values

	// Note: Here instead of log().all() method logging ->
	// we are using addFilter() method with all our request and response logging to TEXT file -> "logging.txt"
	public RequestSpecification requestSpecification() throws IOException
	{

		if(req == null)
		{
//			a)	FileInputStream: Used to read data present in the existing file
//		   b)	FileOutputStream: Used to write new data by creating new file

			// Request Spec common code
			
			// To create a File at RunTime and store external data to file in Java -> we use FileOutputStream
			// To read the data present in file in Java -> we use FileInputStream
			
			// Note: RequestSpecBuilder() and ResponseSpecBuilder() -> we need to use build() method at the end 

			// For RequestSpecification -> we use set() methods.
			// For ResponseSpecification -> we use expect() methods..
			// we use spec() method to pass request and responses and 
			//  spec() method is part of only given() and then() methods only but not when() methods
			PrintStream log = new PrintStream(new FileOutputStream("logging.txt"));
			req = new RequestSpecBuilder().setBaseUri(getGlobalValue("baseURL")).addQueryParam("key", "qaclick123")
					.addFilter(RequestLoggingFilter.logRequestTo(log))
					.addFilter(ResponseLoggingFilter.logResponseTo(log))
					.setContentType(ContentType.JSON).build();
			return req;
		}
		return req;
	}

	// getGlobalValue() used to drive the URL globally to remove hardcoding
	// static used to call  getGlobalValue() method without creating Object

	public static String getGlobalValue(String url) throws IOException
	{
		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream("C:\\Users\\Lenovo\\Desktop\\SDET_Projects\\Selenium_Projects\\automation\\src\\test\\java\\resources\\global.properties");
		prop.load(fis);
		return prop.getProperty(url);
	}
	
	public String getJSONPath(Response response, String key)
	{
		String responseBody = response.asString();
		JsonPath js = new JsonPath(responseBody);		
		return js.get(key).toString();
	}

}
