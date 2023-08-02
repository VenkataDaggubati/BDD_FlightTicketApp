Feature: Ticket Booking Application - Search With Airlines
    
Scenario: Test the availability of flight tickets with some Airlines filters
    Given User navigate to the ticket booking application
    When User search for flights
    Then User should see available flights
    And User navigate to Airlines filter and click
    Then User click on Deselect all link
    And  User can see zero flight results
    Then User select one Airline
    And User should see the flights that match the filters
    