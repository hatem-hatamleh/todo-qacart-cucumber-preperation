Feature: Manage todos
  Scenario: Add new todo
    Given User is in todo page
    When User add a new todo
    Then The added todo should be displayed correctly
