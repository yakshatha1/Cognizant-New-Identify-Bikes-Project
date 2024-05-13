Feature: UpComingHondaBikes
	
	@smoke
  Scenario: Navigate To Upcoming Bikes Page
    Given the user is on the zigWheels home page
    When the user go to new bikes menue
    And the user click on upcoming bikes
    Then the user should redirect to Upcoming Bikes in India page
	
	@smoke @regression
  Scenario: Details Of New Upcoming Bikes
    Given the user is on Upcoming Bikes Page
    When the user select Honda from drop down menue
    Then the user should extract bikes details which are less than Four Lakhs Rs





#Then the user should redirect to Upcoming Bikes in India page
#When the user select Honda from drop down menue 
#Then the user should extract bikes details which are less than Four Lakhs Rs
