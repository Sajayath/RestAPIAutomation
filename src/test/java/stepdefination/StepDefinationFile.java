package stepdefination;



import static io.restassured.RestAssured.given;
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.runner.RunWith;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.api.junit.Cucumber;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import pojoplaceapi.AddPlace;
import pojoplaceapi.Location;
import resources.APIResources;
import resources.TestDataBuild;
import resources.Utils;

@RunWith(Cucumber.class)
public class StepDefinationFile extends Utils{

	RequestSpecification request;
	ResponseSpecification res;
	Response response;
	TestDataBuild data = new TestDataBuild();
	static String placeId; 
	// Here using static, so that placeId-> variable shared across all the Test Cases for particular Run
	// Instead of placeId-> variable become Null after addPlaceAPI run and Null placeId value passed to "GET and Delete" Place API

	// Note:To find the feature code is correctly mapped or not -> Select the Line and click on Control and the selected Line

	@Given("^Add Place Payload \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\"$")
	public void add_place_payload_something_something_something(String name, String language, String address) throws Throwable {
		// Note: Here body/Request payload code mentioned in Given() method
		// Note: For Serialization -> we use Set methods
		// Note: RequestSpecBuilder() and ResponseSpecBuilder() -> we need to use build() method

		// For RequestSpecification -> we use set() methods.
		// For ResponseSpecification -> we use expect() methods..
		// we use spec() method to pass request and responses and 
		//  spec() method is part of only given() and then() methods only but not when() methods

		// Actual request code as part of given() methods
		request = given().spec(requestSpecification())
				.body(data.addPlacePayLoad(name, language, address));

	}

	/* @Given("^Add Place Payload$")
	public void add_Place_Payload() throws Throwable {
	} */

	@When("^User calls \"([^\"]*)\" with \"([^\"]*)\" Http method$")
	public void user_calls_something_with_something_http_method(String resource, String httpMethod) throws Throwable {
		// Actual response code as part of when() and then() methods

		// Here valueOf() method is used to the call Resource in Generic way
		APIResources resourceAPI = APIResources.valueOf(resource); 
		// Here we are creating Object of APIResources and calling APIResources constructor execution happens
		
		// resource -> variable in ENUM class is initialized with value before calling the value of getResource() method

		System.out.println(resourceAPI.getResource());
		// Response common code 
		res = new ResponseSpecBuilder().expectContentType(ContentType.JSON).expectStatusCode(200).build();
		// Imp Note:  spec() method is part of only given() and then() methods only but not when() methods
		
		if(httpMethod.equalsIgnoreCase("POST"))
			response = request.when().post(resourceAPI.getResource())
				.then().spec(res).extract().response();
		else if(httpMethod.equalsIgnoreCase("GET"))
			response = request.when().get(resourceAPI.getResource())
			.then().spec(res).extract().response();
	}

	@Then("^API call got success with Status code (\\d+)$")
	public void api_call_got_success_with_Status_code(int arg1) throws Throwable {
		assertEquals(response.getStatusCode(), 200);


	}
	
	@Then("^\"([^\"]*)\" in response body is \"([^\"]*)\"$")
    public void something_in_response_body_is_something(String key, String expectedValue) throws Throwable {
		assertEquals(getJSONPath(response, key), expectedValue);
		 
		System.out.println(getJSONPath(response, "status"));
		
	}
		
	/*@Then("^\"([^\"]*)\" in response body is \"([^\"]*)\"$")
	public void in_response_body_is(String key, String expectedValue) throws Throwable {				
		assertEquals(getJSONPath(response, key), expectedValue);
	} */
	
	
	@Then("^Verify place_Id  created maps to \"([^\"]*)\" using \"([^\"]*)\"$")
    public void verify_placeid_created_maps_to_something_using_something(String expectedName, String resource) throws Throwable {
		
		placeId = getJSONPath(response, "place_id");
		
		// Actual request code as part of given() methods
		request = given().spec(requestSpecification()).queryParam("place_id", placeId);
		
		// Used to execute the Resource or when method code using below method..
		user_calls_something_with_something_http_method(resource, "GET");
		String actualName = getJSONPath(response, "name");
		assertEquals(expectedName, actualName); // Here expectedName->  we are passing from Feature file
		
    }
	
	@Given("^Delete Place Payload$")
	public void delete_Place_Payload() throws Throwable {
		// Actual request code as part of given() methods
		request = given().spec(requestSpecification()).body(data.deletePlacePayLoad(placeId));
		
	}


}