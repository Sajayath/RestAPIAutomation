package resources;

import java.util.ArrayList;
import java.util.List;

import pojoplaceapi.AddPlace;
import pojoplaceapi.Location;

public class TestDataBuild 
{

	public AddPlace addPlacePayLoad(String name, String language, String address)
	{
		// Note: Here body/Request payload code mentioned in Given() method
		// Note: For Serialization -> we use Set methods 
		// Note: Here to pass Dynamic Payload/Body Globally for now only 3 Values -> name , language, address
		// we have defined data in Feature file using Scenario Outline: with Examples keyword
		AddPlace p = new AddPlace();
		p.setAccuracy(50);
		p.setAddress(address);
		p.setName(name);
		p.setPhone_number("(+91) 983 893 3937");
		p.setAddress("29, side layout, cohen 09");
		p.setWebsite("http://google.com");
		p.setLanguage(language);
		List<String> myList = new ArrayList<String>();
		myList.add("shoe park");
		myList.add("shop");
		p.setTypes(myList);

		Location l = new Location();
		l.setLat(-38.383494);
		l.setLng(33.427362);	
		p.setLocation(l);

		return p;
	}
	
	// Here we use return with ""(double quotes) to return value as String
	public String deletePlacePayLoad(String placeId)
	{
		return "{\r\n    \"place_id\":\""+placeId+"\"\r\n}\r\n";
	}

}
