package stepDefinations;

import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import factory.BaseClass;
import io.cucumber.java.After;
import io.cucumber.java.AfterAll;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeAll;
import io.cucumber.java.Scenario;


public class Hooks {

	 static WebDriver driver;
	 static Properties p;
     
	@BeforeAll
    public static void setup()
    {
		try {
	    	driver=BaseClass.initilizeBrowser();
	    	
	    	p=BaseClass.getProperties();
	    	driver.get(p.getProperty("appURL"));
	    	driver.manage().window().maximize();
		}
		catch(IOException e) {
			System.out.println(e.getMessage());
		}
    			
	}
		
    
    @AfterAll
    public static void tearDown() {
        		
       driver.quit();
       
    }
    

    @AfterStep
    public void addScreenshot(Scenario scenario) { 
    	
    	TakesScreenshot ts=(TakesScreenshot) driver;
    	byte[] screenshot=ts.getScreenshotAs(OutputType.BYTES);
    	scenario.attach(screenshot, "image/png",scenario.getName());     
    }
   
}

