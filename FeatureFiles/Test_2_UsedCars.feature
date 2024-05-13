Feature: UsedCars
	
	@somke 
  Scenario: Navigate To UsedCars Page
    Given the user is on HondaUpcomingBikes In India Page
    When the user clicks on Used Car menu
    Then user should redirect to UsedCar Page

	@smoke @regression
  Scenario: Validate Used Cars In Chennai
    Given the user is on UsedCar page
    When user filters for Chennai City
    Then validate the used Cars In Chennai are Displayed

	@regression
  Scenario: Get Details of Popular Models Of Cars In Chennai
    When user selects CheckBox of Popular Models
    Then extract popular car models details
