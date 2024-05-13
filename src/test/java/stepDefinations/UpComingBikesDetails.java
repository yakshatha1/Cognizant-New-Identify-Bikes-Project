package stepDefinations;



import org.openqa.selenium.WebDriver;

import factory.BaseClass;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObject.HomePage;

public class UpComingBikesDetails extends BaseClass  {

	WebDriver driver;
	
	
	@Given("the user is on the zigWheels home page")
	public void the_user_is_on_the_zigWheels_home_page() {
		getLogger().info("Navigated to the the ZigWheels Website");

	}

	
	@When("the user go to new bikes menue")
	public void the_user_go_to_new_bikes_menue() {
		HomePage homePage = new HomePage(getDriver());
		homePage.hoverOnMenu();
	}

	@When("the user click on upcoming bikes")
	public void the_user_click_on_upcoming_bikes() {

		HomePage homePage = new HomePage(getDriver());
		homePage.selectSubMenu();
	}

	@Then("the user should redirect to Upcoming Bikes in India page")
	public void the_user_should_redirect_to_upcoming_bikes_in_india_page() {
		HomePage homePage = new HomePage(getDriver());
		homePage.validateUpcomingBikesPage();
	}
	
	@Given("the user is on Upcoming Bikes Page")
	public void the_user_is_on_upcoming_bikes_page() {
		getLogger().info("Navigated to the the Upcoming Bikes In India Page");
		getDriver();
	}

	@When("the user select Honda from drop down menue")
	public void the_user_select_honda_from_drop_down_menue() {
		HomePage homePage = new HomePage(getDriver());
		homePage.selectManufacturer();
		
	}

	@Then("the user should extract bikes details which are less than Four Lakhs Rs")
	public void the_user_should_extract_bikes_details_which_are_less_than_four_lakhs_rs() throws Exception {

		HomePage homePage = new HomePage(getDriver());
		homePage.getBikeDetailsLessThanFourLakhs();
	}
}
