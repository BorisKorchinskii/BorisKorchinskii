Feature: Home Page tests

  Scenario: Home Page interface check
    Given I'm on teh Home Page
    Then The browser title is Home Page
    When I login as user epam wth password 1234
    Then The user icon is displayed on teh header
