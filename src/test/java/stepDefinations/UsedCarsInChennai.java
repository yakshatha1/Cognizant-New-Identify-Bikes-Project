package stepDefinations;

import org.testng.Assert;

import factory.BaseClass;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObject.NavigateToUsedCarsPage;

public class UsedCarsInChennai extends BaseClass {

	NavigateToUsedCarsPage navigate;
	String pageTitle ="Used Cars for Sale, Buy Second Hand Cars in India @ Zigwheels";
	String headLine = "Used Cars in Chennai";
	
	@Given("the user is on HondaUpcomingBikes In India Page")
	public void the_user_is_on_honda_upcoming_bikes_in_india_page() {
		getLogger().info("User is On Honda Upcoming Bikes In India Page");
		getDriver();
	}

	@When("the user clicks on Used Car menu")
	public void the_user_clicks_on_used_car_menu() {
	    navigate = new NavigateToUsedCarsPage(getDriver());
	    navigate.clickOnUsedCars();
	}

	@Then("user should redirect to UsedCar Page")
	public void user_should_redirect_to_used_car_page() {
		navigate = new NavigateToUsedCarsPage(getDriver());
		Assert.assertEquals(navigate.getTitleOfPage(),pageTitle);	    
	}

	@Given("the user is on UsedCar page")
	public void the_user_is_on_used_car_page() {
		getLogger().info("Navigated to the Used Cars Page");
		getDriver();
	}

	@When("user filters for Chennai City")
	public void user_filters_for_chennai_city() {
		navigate = new NavigateToUsedCarsPage(getDriver());
	    navigate.filterByCity();
	}

	@Then("validate the used Cars In Chennai are Displayed")
	public void validate_the_used_cars_in_chennai_are_displayed() {
		navigate = new NavigateToUsedCarsPage(getDriver());
		Assert.assertEquals(navigate.validateUsedCarsCity(),headLine);	    
	}

	@When("user selects CheckBox of Popular Models")
	public void user_selects_check_box_of_popular_models() {
		navigate = new NavigateToUsedCarsPage(getDriver());
	    navigate.clickCheckBoxs();
	}

	@Then("extract popular car models details")
	public void extract_popular_car_models_details() throws Exception {
		navigate = new NavigateToUsedCarsPage(getDriver());
	    navigate.getDetailsOfCars();
	}

}
