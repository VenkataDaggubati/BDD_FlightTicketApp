package StepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import PageFactory.TicketSearchApp;

public class SeatAvailability {
	
	WebDriver driver;
	TicketWebsiteLaunch launch;
	TicketSearchApp searchPageApp;
	FlightsSearch FlightSearchObj;
	SearchWithFilter searchWithFilter;
	
	@Given("^User navigate to the ticket booking website$")
    public void userNavigateToTheTicketBookingWebsite() {
		launch.launchchrome_browser();
		launch.enter_opodo_url();
		FlightSearchObj.User_search_for_a_flight_from_to(null, null);
		searchWithFilter.userSetTheDepartureDateTo(null);
		
    }

    @When("^User search for flights$")
    public void userSearchForFlights() {
    	searchPageApp.ClickSearch();
    }

    @Then("^User should see available flights$")
    public void userShouldSeeAvailableFlights() {
        FlightSearchObj.User_should_see_available_flights();
    }

    @When("^User select a flight$")
    public void userSelectAFlight() {
        searchPageApp.SelectFlight();
    }

    @Then("^User navigate to Choose your seats tab$")
    public void userNavigateToChooseYourSeatsTab() {
        WebElement seatSelecttab= driver.findElement(By.xpath("//span[text()='Aisle or window?']"));
    System.out.println(seatSelecttab.getText());
    }

    @And("^User select Window seat and confirm seat$")
    public void userSelectWindowSeatAndConfirmSeat() {
    	searchPageApp.SelectWindowSeat();
    	searchPageApp.ConfirmSeat();
    }

    @And("^Verify selected seat is a Window seat$")
    public void verifySelectedSeatIsAWindowSeat() {
        WebElement isSelectedWindow= driver.findElement(By.xpath("//div[contains(@class,'odf-icon-pax') and @data-type='window']"));
        isSelectedWindow.isSelected();
        System.out.println("User selected Window seat");
        
    }

    @Then("^User select aisle seat and confirm seat$")
    public void userSelectAisleSeatAndConfirmSeat() {
    	searchPageApp.SelectAisleSeat();
    	searchPageApp.ConfirmSeat();
    }

    @And("^Verify selected seat is a aisle seat$")
    public void verifySelectedSeatIsAisleSeat() {
    	WebElement isSelectedAisle= driver.findElement(By.xpath("//div[contains(@class,'odf-icon-pax') and @data-type='aisle']"));
    	isSelectedAisle.isSelected();
        System.out.println("User selected Aisle seat");
        
        
    }

}
