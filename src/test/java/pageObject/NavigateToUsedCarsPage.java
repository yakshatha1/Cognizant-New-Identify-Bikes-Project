package pageObject;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Utility.DataReader;
import factory.BaseClass;


public class NavigateToUsedCarsPage extends BaseClass{

	WebDriver driver;
	DataReader dataReader;
	String filePath = System.getProperty("user.dir")+"\\TestData\\UsedCar.xlsx";
	
	//Constructor
	public NavigateToUsedCarsPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy (xpath = "//a[normalize-space()='Used Cars']")
	WebElement usedCarElement;
	
	@FindBy (xpath = "//div[@id='city-popup']")
	WebElement cityPopupElement;
	
	@FindBy (xpath = "//input[@id='gs_input5']")
	WebElement popupInputElement;
	
	@FindBy (xpath = "//input[@id='usedCarCity']")
	WebElement inputCityElement;
	
	@FindBy (xpath="//h1[@id='usedcarttlID']")
	WebElement headLineTextElement;
	
	@FindBy (xpath="//h1[contains(text(),'Chennai')]")
	WebElement waitElement;
	
	
	@FindBy (xpath = "//a[text()='Chennai']")
	WebElement cityDropDownElement;
	
	@FindBy (xpath = "//ul[contains(@class,'usedCarMakeModelList')]//li//span//input")
	List<WebElement> popularModelsCheckBoxList;
	
	public void clickOnUsedCars() {
		scrollTop();
		usedCarElement.click();
	} 
	
	public String getTitleOfPage() {
		return driver.getTitle();
	}
	
	public void filterByCity() {
		if(cityPopupElement.isDisplayed()) {
			popupInputElement.sendKeys("Chennai");
			cityDropDownElement.click();
		}
		else {
			
			inputCityElement.click();
			inputCityElement.clear();
			inputCityElement.sendKeys("Chennai");
			cityDropDownElement.click();
		}
		
	}
	
	public String validateUsedCarsCity() {
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOf(waitElement));
		
		String txt = headLineTextElement.getText();
		System.out.println(txt);
		return txt;
	}
	
	public void clickCheckBoxs() {
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		scrollDown();
		for(WebElement eachElement : popularModelsCheckBoxList ) 
		{
			jse.executeScript("arguments[0].click();",eachElement);
		}
		
	}
	
	public void getDetailsOfCars() throws Exception {
		
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		scrolltoEnd();
		scrolltoEnd();
		jse.executeAsyncScript("window.setTimeout(arguments[arguments.length - 1], 8);");
		
		List<WebElement> usedCarCardElements = driver.findElements(By.xpath("//div[@id='data-set-body']//div[@class='zw-sr-searchTarget col-lg-4']"));
		System.out.println(usedCarCardElements.size()); 
		
		dataReader = new DataReader(filePath);
		dataReader.createSheet("UsedCar");
		
		dataReader.setCellData("UsedCar", 0, 0, "Name Of Car");
		
		int counter = 1;		
		for(WebElement eachElement : usedCarCardElements)
		{
			String []usedCarDetails = eachElement.getText().split("\n");
			for(String eachCar:usedCarDetails) {
				
				dataReader.setCellData("UsedCar", counter, 0, usedCarDetails[1]);
				System.out.println(eachCar);
			}
			counter++;
		}
		dataReader.closeBook();
		
	}
	
}
