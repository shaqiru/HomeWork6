Feature: login failed
  This feature login with invalid credential

  Scenario: User logs in with invalid credentials
    Given user navigates to website "Saucedemo"
    When the user enters the invalid username and password
    And clicks the "Login" button at home page
    Then error message should be displayed