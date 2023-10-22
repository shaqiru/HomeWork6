Feature: login standard user
  This feature login with correct credential

  Scenario: User logs in with valid credentials
    Given user navigates to website
    When the user enters the correct username and password
    And clicks the "Login" button
    Then he can see the page of products "https://www.saucedemo.com/inventory.html"