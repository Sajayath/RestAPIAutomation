package pojoplaceapi;

import java.util.List;

// Note: Java related code other than Testing code should be present in src/main/java package 
// As Pojo is not related to Testing specific code

//Note: To get Getters and Setters -> 1) Select all the variables 
// 2) Use -> ALT+SHIFT+S 3) Select the Generate Getters and Setters tab..
public class AddPlace 
{

	private int accuracy;
	private Location location;
	private String name;
	private String phone_number;
	private String address;
	private String website;
	private String language;
	private List<String> types;

	public int getAccuracy() {
		return accuracy;
	}
	public void setAccuracy(int accuracy) {
		this.accuracy = accuracy;
	}
	public Location getLocation() {
		return location;
	}
	public void setLocation(Location location) {
		this.location = location;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhone_number() {
		return phone_number;
	}
	public void setPhone_number(String phone_number) {
		this.phone_number = phone_number;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getWebsite() {
		return website;
	}
	public void setWebsite(String website) {
		this.website = website;
	}
	public String getLanguage() {
		return language;
	}
	public void setLanguage(String language) {
		this.language = language;
	}
	public List<String> getTypes() {
		return types;
	}
	public void setTypes(List<String> types) {
		this.types = types;
	}



}
