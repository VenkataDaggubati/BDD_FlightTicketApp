  Feature: Ticket Booking Application - Select seat availability
  
  Scenario: Test if flight seat number is a window seat or an aisle seat
    Given User navigate to the ticket booking website
    When User search for flights
    Then User should see available flights
    When User select a flight
    Then User navigate to Choose your seats tab
    And User select Window seat and confirm seat
    And Verify selected seat is a Window seat
    Then User select aisle seat and confirm seat
    And Verify selected seat is a aisle seat
