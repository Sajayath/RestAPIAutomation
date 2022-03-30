package pojo;

public class GetCourseResponse {

	// Note: To get Getters and Setters -> 1) Select the variables 
	// 2) Use -> ALT+SHIFT+S 3) Select the Generate Getters and Setters tab..
	
	private String instructor;
	private String url;
	private String services;
	private String expertise;
	private CoursesFirstChild courses;
	private String linkedIn;
		
	public String getInstructor() {
		return instructor;
	}
	public void setInstructor(String instructor) {
		this.instructor = instructor;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getServices() {
		return services;
	}
	public void setServices(String services) {
		this.services = services;
	}
	public String getExpertise() {
		return expertise;
	}
	public void setExpertise(String expertise) {
		this.expertise = expertise;
	}
	public CoursesFirstChild getCourses() {
		return courses;
	}
	public void setCourses(CoursesFirstChild courses) {
		this.courses = courses;
	}
	public String getLinkedIn() {
		return linkedIn;
	}
	public void setLinkedIn(String linkedIn) {
		this.linkedIn = linkedIn;
	}
	
	

}
