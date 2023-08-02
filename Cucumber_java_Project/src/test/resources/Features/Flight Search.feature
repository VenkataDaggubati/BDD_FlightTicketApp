Feature: Ticket Booking Application - Flight Search

Scenario Outline: Test if the flights are available from any two destinations on specific dates
    Given User navigate to the ticket booking website
    When User search for a flight from "<from>" to "<to>"
    And User set the departure date to "<departureDate>" and return date to "<returnDate>"
    Then User click on Search Flights button
    And User should see available flights

    Examples:
    | from   | to       | departureDate | returnDate  |
    | London | Italy    | 2023-09-01    | 2023-09-10  |
    | Paris  | Barcelona| 2023-10-01    | 2023-10-10  |
    
  
    