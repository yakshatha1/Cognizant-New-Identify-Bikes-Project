package pageObject;

import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import Utility.DataReader;

public class HomePage {
	WebDriver driver;
	DataReader dataReader;
	String filePath = System.getProperty("user.dir")+"\\TestData\\BikeDetails.xlsx";
	//Constructor
	public HomePage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	// Finding the Elements
	@FindBy(xpath = "//a[normalize-space()='New Bikes']")
	WebElement newBikesElement;
	
	@FindBy(xpath = "//span[@data-tag-url='/upcoming-bikes']")
	WebElement upcomingBikesElement;
	
	@FindBy(id = "makeId")
	WebElement manufacturerElement;
	
	@FindBy (xpath = "//span[@class='zw-cmn-loadMore']")
	WebElement viewMoreElement;
	
	@FindBy (xpath = "//li[contains(@class,'modelItem')]")
	List<WebElement> allUpcomingBikes;
	
	
	//Navigate to the Upcoming Bikes section
	public void hoverOnMenu(){
		
		//Creating object for action class
		// Performing mouse Hover action
		Actions actions = new Actions (driver);
		actions.moveToElement(newBikesElement).build().perform();
	}
	
	public void selectSubMenu() {
		upcomingBikesElement.click();
	}
	
	public void validateUpcomingBikesPage() {
		String title = driver.getTitle();
	    Assert.assertEquals(title, "Upcoming Bikes in India - Check Price, Launch Date, Images and Latest News");
	}
	
	public void selectManufacturer() {
		Select manufacturerList = new Select(manufacturerElement);
		manufacturerList.selectByVisibleText("Honda");
	}
	
	public void getBikeDetailsLessThanFourLakhs() throws Exception {	
		
		//Scrolling to to find viewMore element
		JavascriptExecutor jsExecutor = (JavascriptExecutor)driver;
		jsExecutor.executeScript("arguments[0].scrollIntoView();",viewMoreElement);	
		
		// click on the View More element 
		jsExecutor.executeScript("arguments[0].click();", viewMoreElement);
		dataReader = new DataReader(filePath);
		dataReader.createSheet("UpcomingBikes");
		
		dataReader.setCellData("UpcomingBikes", 0, 0, "Name Of Bike");
		dataReader.setCellData("UpcomingBikes", 0, 1, "Price");
		dataReader.setCellData("UpcomingBikes", 0, 2, "Launch Date");
		
		int counter = 1;
		for(WebElement element : allUpcomingBikes) 
		{
			if((Integer.parseInt(element.getAttribute("data-price")))<=400000) 
			{
				String [] cardText =element.getText().split("\n");
				for(String eachCard : cardText) {
					dataReader.setCellData("UpcomingBikes", counter, 0, cardText[0]);
					dataReader.setCellData("UpcomingBikes", counter, 1, cardText[1]);
					dataReader.setCellData("UpcomingBikes", counter, 2, cardText[2]);
					System.out.println(eachCard);
				}
				counter++;
			}	
		}
		dataReader.closeBook();
	}
}
