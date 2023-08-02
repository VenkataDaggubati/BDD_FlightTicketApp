package StepDefinitions;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.concurrent.TimeUnit;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;


public class TicketWebsiteLaunch {
	WebDriver driver=null;
	
	
	@Given("^User launch chrome browser$")
	public void launchchrome_browser() {
		String projectPath=System.getProperty("user.dir");
				System.out.println("Project path is:"+projectPath);
		System.setProperty("webdriver.chrome.driver", projectPath+"/src/test/resources/Drivers/chromedriver.exe");
	     driver= new ChromeDriver();
	    
	     driver.manage().window().maximize();
	     
	    
	    
		System.out.println("Launching Chrome browser");
	}

	@When("^User enter Ticket Booking application URL$")
	public void enter_opodo_url() {
		driver.navigate().to("https://www.opodo.co.uk/");
	    
	    System.out.println("User enter Ticket booking site URL");
	}
 @SuppressWarnings("deprecation")
@And("^Verify the Title of Ticket Booking application$")
 public void verify_title() {
	 
	 driver.manage().deleteAllCookies();
	 driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS); 
	   
  String title= driver.getTitle();
  
  System.out.println(title);
  Assert.assertEquals("Book cheap holidays: flights, hotels and car hire - Opodo ", "title");
 }
	@Then("^User sucessfully launch Ticket Booking application$")
	public void enter_into_Opodo_Ticketsite() {
		 WebElement logo = driver.findElement(By.id("logo"));
	        try {
	            new Actions(driver).moveToElement(logo).click().perform();
	            Assert.assertTrue(true);
	        } catch(Exception e) {
	            Assert.fail("Logo is not clickable.");
	        }
	    System.out.println("User enter into Opodo Ticket booking site");
	}



		
	}


