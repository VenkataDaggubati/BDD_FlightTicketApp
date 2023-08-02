package StepDefinitions;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;

import PageFactory.TicketSearchApp;


public class SearchWithFilter {

	WebDriver driver;
	TicketWebsiteLaunch launch;
	TicketSearchApp searchPageApp;
	FlightsSearch FlightSearchObj;

	    @Given("^User navigate to the Ticket Booking application$")
	    public void userNavigateToTheTicketBookingApplication() {
	    	launch.launchchrome_browser();
			launch.enter_opodo_url();
	    }

	    @When("^User can see Return button auto selected$")
	    public void userCanSeeReturnButtonAutoSelected() {
	        WebElement returnButton = driver.findElement(By.xpath("//input[id='tripTypeSwitcher_roundTrip']"));
	        if (returnButton.isSelected()) {
	        	System.out.println("Return button is auto selected");
				
			}else {
				System.out.println("Return button is not selected");
				
			}
	    }

	    @Then("^User select the one way trip button$$")
	    public void userSelectTheOneWayTripButton() {
	    	searchPageApp.SelectOneWaybutton();
	    	System.out.println("OneWay button is selected");
	    }

	    @And("^Verify Return Date field is disappear")
	    public boolean verifyReturnDateFieldIsDisappear() {
	    	 WebElement returnDate = driver.findElement(By.xpath("//input[@placeholder='Return']"));
	    	 if(returnDate.isDisplayed()) {
	 			System.out.println("false:Return Date field is appear ");
	 			 return false;
	 			
	 		}else {
	 			System.out.println("true: Return Date field is disappear");
	 			return true;
	 			
	 		}   
	    	 
	    }

	    @And("^Verify Add another flight link appear$")
	    public void verifyAddAnotherFlightLinkAppear() {
	        WebElement addAnotherFlightLink = driver.findElement(By.xpath("//span[text()='Add another flight']"));
	        assert addAnotherFlightLink.isDisplayed();
	        System.out.println("Add another flight link displayed");
	    }

	    @When("^User can see Economy is default class$")
	    public void userCanSeeEconomyisDefaultClass() {
	    	
	        WebElement economyClass= driver.findElement(By.xpath("//span[normalize-space()='Economy']"));
	        economyClass.click();
	        WebElement ActiveClass= driver.findElement(By.xpath("//li[@class='odf-text-md odf-text-nowrap odf-dropdown-item  active']"));
	       System.out.println( ActiveClass.getText());
	    }
	    

	    @Then("^User select Business class$")
	    public void userSelectBusinessClass() {
	    	searchPageApp.SelectBusinessClass();
	    }

	    @And("^User search for a flight from {string} to {string}$")
	    public void userSearchForAFlightFromTo(String from, String to) {
	    	searchPageApp.enterWhereFrom(from);
	    	searchPageApp.enterWhereTo(to);
	    }

	    @And("^User set the departure date to {string}$")
	    public void userSetTheDepartureDateTo(String departureDate) {
	    	searchPageApp.enterDeparture(departureDate);
	    }

	    @And("^User click on Search Flights button$")
	    public void userClickOnSearchFlightsButton() {
	        searchPageApp.ClickSearch();
	    }

	    @Then("^User should see the flights that match the filters$")
	    public void userShouldSeeTheFlightsThatMatchTheFilters() {
	    	FlightSearchObj.User_should_see_available_flights();
	        
	    }
	}





