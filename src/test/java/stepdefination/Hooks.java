package stepdefination;

import cucumber.api.java.Before;

public class Hooks {
	
	
	// Note: If place id is not present -> we use Hooks concept before Delete Place -> 
	// Add place API should run and Place id to be captured
	@Before("@DeletePlace")
	public void beforeScenario() throws Throwable
	{
		StepDefinationFile file = new StepDefinationFile();
		
		// Here we are calling "placeId" with Class name as it static variable instead of object reference..
		if(StepDefinationFile.placeId == null)
		{
		file.add_place_payload_something_something_something("Shetty", "German", "Asia");
		file.user_calls_something_with_something_http_method("addPlaceAPI", "POST");
		file.verify_placeid_created_maps_to_something_using_something("Shetty", "getPlaceAPI");
		}
	}

}
