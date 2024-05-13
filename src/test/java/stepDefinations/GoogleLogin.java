package stepDefinations;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import factory.BaseClass;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObject.LoginWithGoogle;

public class GoogleLogin extends BaseClass{
	
	
	LoginWithGoogle loginWithGoogle;
	String headerText = "Login/Register to ZigWheels";
	String windowTitle = "Sign in - Google Accounts";
	String emailErrorMsg = "Couldn’t find your Google Account";

	@Given("user is on the ZiggWheels Home page")
	public void user_is_on_the_zigg_wheels_home_page() {
		loginWithGoogle = new LoginWithGoogle(getDriver());
		loginWithGoogle.clickOnLogo();
		getLogger().info("User is On ZigWheels Home Page");
		getDriver();
	}

	@When("user clicks the login button")
	public void user_clicks_the_login_button() {
		loginWithGoogle = new LoginWithGoogle(getDriver());
		loginWithGoogle.clickOnLogInButton();
	}

	@Then("user should navigate to Login Window")
	public void user_should_navigate_to_login_window() {
		loginWithGoogle = new LoginWithGoogle(getDriver());
	    Assert.assertEquals(loginWithGoogle.navigateToLoginWindow(),headerText);
	}

	@Given("user is on Login window")
	public void user_is_on_login_window() {
		getLogger().info("User is On Login Window");
	}

	@When("user clicks on Google login button")
	public void user_clicks_on_google_login_button() {
		loginWithGoogle = new LoginWithGoogle(getDriver());
		loginWithGoogle.loginByGoogle();
		loginWithGoogle.handelWindows();
	}

	@Then("user redirects to Google Account Login Window")
	public void user_redirects_to_google_account_login_window() {
		loginWithGoogle = new LoginWithGoogle(getDriver());
		
	    Assert.assertEquals(loginWithGoogle.validateGoogleAccountLoginWindow(),windowTitle);
	}

	@Given("user is on Google Account Login Window")
	public void user_is_on_google_account_login_window() {
		getLogger().info("User is On Google Account Login");

	}

	@When("user enters an invalid email")
	public void user_enters_an_invalid_email() {
		loginWithGoogle = new LoginWithGoogle(getDriver());
		loginWithGoogle.enterInvalidEmail();

	}

	@Then("user should see the Email error message")
	public void user_should_see_the_email_error_message() {
		loginWithGoogle = new LoginWithGoogle(getDriver());
		Assert.assertEquals(loginWithGoogle.getErrorText(), loginWithGoogle.getErrorText());

	}

	@When("user enters an invalid PhoneNo")
	public void user_enters_an_invalid_phone_no() {
		loginWithGoogle = new LoginWithGoogle(getDriver());
		loginWithGoogle.enterInvalidPhoneNo();
	}
	
	@Then("user should see the PhoneNo error message")
	public void user_should_see_the_phone_no_error_message() {
		loginWithGoogle = new LoginWithGoogle(getDriver());
		Assert.assertEquals(loginWithGoogle.getErrorText(), loginWithGoogle.getErrorText());

	}
}
