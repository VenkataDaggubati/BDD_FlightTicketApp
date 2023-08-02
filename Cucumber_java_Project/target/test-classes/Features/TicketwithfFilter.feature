Feature: Ticket Booking Application - Search With Filters
    
Scenario: Test the availability of flight tickets with some filters
    Given User navigate to the Ticket Booking application
    When User can see Return button auto selected
    Then User select the one way trip button
    And Verify Return Date field is disappear
    And Verify Add another flight link appear
    When User can see Economy is default class
    Then User select Business class 
    And User search for a flight from "<from>" to "<to>"
    And User set the departure date to "<departureDate>"
    And User click on Search Flights button
    Then User should see the flights that match the filters
    
    Examples:
    | from   | to       | departureDate |
    | London | Italy    | 2023-09-01    | 
    | Paris  | Barcelona| 2023-10-01    | 

