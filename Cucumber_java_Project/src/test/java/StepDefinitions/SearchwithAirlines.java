package StepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import PageFactory.TicketSearchApp;

public class SearchwithAirlines {
	
	WebDriver driver;
	TicketWebsiteLaunch launch;
	TicketSearchApp searchPageApp;
	FlightsSearch FlightSearchObj;
	SearchWithFilter searchWithFilter;

    @Given("^User navigate to the ticket booking application$")
    public void userNavigateToTheTicketBookingApplication() {
    	launch.launchchrome_browser();
		launch.enter_opodo_url();
		FlightSearchObj.User_search_for_a_flight_from_to(null, null);
		searchWithFilter.userSetTheDepartureDateTo(null);;
    }

    @When("^User search for flights4")
    public void userSearchForFlights() {
    	searchPageApp.ClickSearch();
    }

    @Then("^User should see available flights$")
    public void userShouldSeeAvailableFlights() {
    	 FlightSearchObj.User_should_see_available_flights();
    }

    @And("^User navigate to Airlines filter and click$")
    public void userNavigateToAirlinesFilterAndClick() {
    	WebElement airlines= driver.findElement(By.xpath("//span[text()='Airlines']"));
    	airlines.click();
        
    }

    @Then("^User click on Deselect all link$")
    public void userClickOnDeselectAllLink() {
    	WebElement AirlinesDeselect= driver.findElement(By.xpath("//a[text()='Deselect all']"));
    	AirlinesDeselect.click();
    	
    }

    @And("^User can see zero flight results$")
    public void userCanSeeZeroFlightResults() {
    WebElement SelectFlight= driver.findElement(By.xpath("//div[contains(@class,'result od-resultpage-wrapper highlighted odf-box')]//div//button[@class='book_btn odf-btn odf-btn-block odf-btn-primary odf-clickable odf-text-nowrap book_with_prime_btn'][normalize-space()='Select']\""));
    	if(SelectFlight.isDisplayed()) {
    		System.out.println("Flight results are available ");
			
			
		}else {
			System.out.println("Flight results are not available");
			
    }
    }
    @Then("^User select one Airline$")
    public void userSelectOneAirline() {
    	WebElement Airlineselect= driver.findElement(By.xpath("//input[@value='BA']"));
    	Airlineselect.click();
    	
        
    }

    @And("^User should see the flights that match the filters$")
    public void userShouldSeeTheFlightsThatMatchTheFilters() {
    	WebElement AirlineTicketsCount= driver.findElement(By.xpath("//div[text()='  · British Airways']"));
    	
    	WebElement SelectFlight= driver.findElement(By.xpath("//div[contains(@class,'result od-resultpage-wrapper highlighted odf-box')]//div//button[@class='book_btn odf-btn odf-btn-block odf-btn-primary odf-clickable odf-text-nowrap book_with_prime_btn'][normalize-space()='Select']\""));
    	
    	if (AirlineTicketsCount.getSize()==SelectFlight.getSize()) {
    		System.out.println("True:Flight tickets are only British Airways ");
			
		}else {
			System.out.println("False:Flight tickets not only British Airways");
		}
    }

}
