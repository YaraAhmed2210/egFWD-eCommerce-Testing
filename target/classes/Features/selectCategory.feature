@smoke
Feature: Logged User shall select random category, use filtering in products
Background:
  Given user open the browser
  And user navigates to the login page
  And user enter "yaraa2211@yahoo.com" and "123456" then click on login btn
  Then user logged in successfully to the home page



#Test Scenario 1
  Scenario: Logged user shall select different random categories
    When user selects random category
    Then redirected to category's products
    And user selects random category
    Then redirected to category's products

#Test Scenario 2
  Scenario: Logged user shall filter with color
    When user go to specific category
    And filter category products by color
    Then products should be filtered successfully
