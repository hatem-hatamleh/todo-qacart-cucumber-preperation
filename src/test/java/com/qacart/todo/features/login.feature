Feature: Login feature
  Scenario: Login with email and password
    Given User is in the login page
    When User fill the login form and submit
    Then User should navigate to the todo page