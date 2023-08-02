package StepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import PageFactory.TicketSearchApp;



public class FlightsSearch{
	
	WebDriver driver;
	TicketWebsiteLaunch launch;
	TicketSearchApp searchPageApp;
	   
	@Given("^User navigate to the ticket booking website$")
    public void Navigat_to_bookingwebsite() throws InterruptedException {
		launch.launchchrome_browser();
		launch.enter_opodo_url();
		Thread.sleep(1000);
    }

	@When("^User search for a flight from {string} to {string}$")
    public void User_search_for_a_flight_from_to(String from, String to) {
    	searchPageApp.enterWhereFrom(from);
    	searchPageApp.enterWhereTo(to);
    }

	 @And("^User set the departure date to {string} and return date to {string}$")
    public void i_set_the_departure_date_and_return_date(String departureDate, String returnDate) {
        searchPageApp.enterDeparture(departureDate);
        searchPageApp.enterReturn(returnDate);
    }

    @Then("^User click on Search Flights button$")
    	public void i_clickon_search_button() {
    	searchPageApp.ClickSearch();
    }
    
    @And("^User should see available flights$")
    public void User_should_see_available_flights() {
        try {
            Thread.sleep(5000); // Wait for results page to load
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
       
        
        WebElement flightResults= driver.findElement(By.xpath("//span[@class='css-57xm4i-BaseText-Text ek4n60o0']"));
       
        System.out.println(flightResults.getText());
        driver.quit();
    }

	
}