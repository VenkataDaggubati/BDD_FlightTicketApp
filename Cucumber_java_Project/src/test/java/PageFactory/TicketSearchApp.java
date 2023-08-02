package PageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class TicketSearchApp {
	
	WebDriver driver;
	public TicketSearchApp(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, TicketSearchApp.class);
	}
		
	
	@FindBy(how = How.XPATH,using ="//input[id='tripTypeSwitcher_oneWayTrip']")
	WebElement OneWayBtn;
	
	@FindBy(how = How.XPATH,using ="//input[id='tripTypeSwitcher_roundTrip']")
	WebElement ReturnBtn;
	
	@FindBy(how = How.XPATH,using ="//input[id='tripTypeSwitcher_multipleTrip']")
	WebElement MultiCityBtn;
	
	
	@FindBy(how = How.XPATH,using ="//li[@class='odf-text-md odf-text-nowrap odf-dropdown-item ' and text()='Business']")
	 WebElement BusinessClass;
	
	@FindBy(how = How.XPATH,using ="//li[@class='odf-text-md odf-text-nowrap odf-dropdown-item  active']")
	WebElement ActiveClass;
	
	@FindBy(how = How.XPATH,using ="//input[@placeholder='Where from?']")
	WebElement whereFrom;
	
	@FindBy(how = How.XPATH,using ="//input[@placeholder='Where to?']")
	WebElement whereTo;
	
	@FindBy(how = How.XPATH,using ="//input[@placeholder='Departure']")
	WebElement Departure;
	
	
	@FindBy(how = How.XPATH,using ="//input[@placeholder='Return']")
	WebElement Return;
	
	@FindBy(how = How.XPATH,using ="//div[@data-testid='pax-selector-summary']")
	WebElement SelectTraveller;
	
	@FindBy(how = How.XPATH,using = "//span[@class='odf-icon odf-icon-plus odf-icon-xl']")
    WebElement AddTravellers;
	
	@FindBy(how = How.ID, using = "direct-flight-switcher")
    WebElement DirectFlightCheckbx;
	
	@FindBy(how = How.XPATH,using = "//button[@test-id='search-flights-btn']")
    WebElement SearchBtn;
	
	@FindBy(how = How.XPATH,using = "//span[text()='Add another flight']")
    WebElement AddanotherFlight;
	
	@FindBy(how = How.XPATH,using = "//div[contains(@class,'result od-resultpage-wrapper highlighted odf-box')]//div//button[@class='book_btn odf-btn odf-btn-block odf-btn-primary odf-clickable odf-text-nowrap book_with_prime_btn'][normalize-space()='Select']")
    WebElement SelectFlight;

	@FindBy(how = How.XPATH,using = "//div[@data-texttype='Window seat' and (@data-column='A' or @data-column='F')]")
    WebElement SelectWindowSeat;
	
	@FindBy(how = How.XPATH,using = "//div[@data-texttype='Aisle seat' and (@data-column='C' or @data-column='D')]")
    WebElement SelectAisleseat;
	
	@FindBy(how = How.XPATH,using = "//span[normalize-space()='Confirm']")
    WebElement ConfirmSeat;
	
	@FindBy(how = How.XPATH,using = "//span[contains(@class,'od-seatmapselection-status-selected')]")
    WebElement ChangeSeat;
	
	
	
	
	public void SelectOneWaybutton() {
		OneWayBtn.click();
	}
	public void SelectReturnbutton() {
		ReturnBtn.click();
		}
	
	public void SelectMultiCitybutton() {
		MultiCityBtn.click();
		}
	
	public void SelectBusinessClass() {
		BusinessClass.click();
		}
	
	public void enterWhereFrom(String from) {
		whereFrom.sendKeys(from);
		}

	public void enterWhereTo(String to) {
		whereTo.sendKeys(to);
		}
	
	public void enterDeparture(String departureDate) {
		Departure.sendKeys(departureDate);
		}

	public void enterReturn(String returnDate) {
		Return.sendKeys(returnDate);
		}
	public void ClickSearch() {
	SearchBtn.click();
	}
	
	public void SelectFlight() {
		SelectFlight.click();
	}
	
	public void SelectWindowSeat() {
		SelectWindowSeat.click();
	}
	
	public void SelectAisleSeat() {
		SelectAisleseat.click();
	}
	
	public void ConfirmSeat() {
		ConfirmSeat.click();
	}
}
