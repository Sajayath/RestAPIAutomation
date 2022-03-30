package resources;

// We are using ENUM class as we have 100's of API in RealTime Project 
// which in Java we need to write more code to avoid it we are using ENUM class as directly we use enum methods to access values
// Note: Enum is special class in Java which has collection of Constants or Methods
// Each method is separated with comma(,) and after all methods ended with ;
public enum APIResources 
{
	// Method declaration in ENUM class
	// Note: Here method name should be same as String present in "When" Step of Feature file to trigger particular API in Generic way
	addPlaceAPI("/maps/api/place/add/json"),
	getPlaceAPI("/maps/api/place/get/json"),
	deletePlaceAPI("/maps/api/place/delete/json");
	
	private String resource;
	// Note: Here APIResources() Constructor called to make sure String values are passed in above defined Methods..
	// APIResources() Constructor should not have public as default it is Public..
	APIResources(String resource)
	{
		this.resource = resource;
	}
	
	// To return the Resource value we need to use Getter method..
	
	public String getResource()
	{
		return resource;
	}

}
