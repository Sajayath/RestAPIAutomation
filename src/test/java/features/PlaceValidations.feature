Feature: Validating Place API's
# Here Feature: is like TestSuite and Scenario is like Test Case and Feature contain multiple Test Cases
# Scenario Outline: used for Parameterization
# To Comment in Feature file, we need to use # special character..

# Here we are making the Features Generic so that less lines of code which work for all the Requests

# Here Add and GET Place API Scenario (Test case)

# Note: we can have multiple Tags for the SCENARIOS Ex: @Tag1 @Tag2 @Tag3 -> Here there should be Space between each @Tag
@AddPlace @Regression
Scenario Outline: Verify if Place is successfully added using given AddPlaceAPI
    Given Add Place Payload "<name>" "<language>" "<address>"
    When User calls "addPlaceAPI" with "POST" Http method 
    Then API call got success with Status code 200
    And "status" in response body is "OK"
    And "scope" in response body is "APP"
    And Verify place_Id  created maps to "<name>" using "getPlaceAPI"
    
Examples:
	| name 			  | language  | address 				  | 
	| Frontline house | French-IN | 29, side layout, cohen 09 | 
#	| Backline ment   | English-IN| 40, side layout, mehan 09 | 


@DeletePlace @Regression
Scenario: Verify if Delete Place functionality is working
    Given Delete Place Payload
   	When User calls "deletePlaceAPI" with "POST" Http method 
    Then API call got success with Status code 200
    And "status" in response body is "OK"
	    
  
  