Feature: Google Login
	
	@smoke
  Scenario: Navigate Back To ZiggWheels Home Page
    Given user is on the ZiggWheels Home page
    When user clicks the login button
    Then user should navigate to Login Window

	@smoke @regression
  Scenario: Validate Google Login Page
    Given user is on Login window
    When user clicks on Google login button
    Then user redirects to Google Account Login Window

	@regression
  Scenario: Login with invalid emailId
    Given user is on Google Account Login Window
    When user enters an invalid email
    Then user should see the Email error message

	@regression
  Scenario: Login with invalid PhoneNo
    Given user is on Google Account Login Window
    When user enters an invalid PhoneNo
    Then user should see the PhoneNo error message 
 
