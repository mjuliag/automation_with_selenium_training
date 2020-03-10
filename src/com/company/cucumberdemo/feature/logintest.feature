Feature: Login

  Scenario: Successful Login with valid	credentials
    Given User is on the home page
    When  User enters username and password
    Then  A welcome text is displayed
