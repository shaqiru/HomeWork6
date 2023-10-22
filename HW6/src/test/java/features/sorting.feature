Feature: Sorting Product

  Scenario: choose price (high to low)
    Given success login to saucdemo
    When user clik Name (A to Z) in top right
    And user choose price (high to low)
    Then will display list product in home page will sorting based on price high to low