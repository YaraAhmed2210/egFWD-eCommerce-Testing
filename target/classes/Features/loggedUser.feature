@smoke
Feature: Logged user shall search for product, switch between currencies
Background:
  Given user open the browser
  And user navigates to the login page
  And user enter "yaraa2211@yahoo.com" and "123456" then click on login btn
  Then user logged in successfully to the home page

#Test Scenario 1: Logged user shall search for product
  Scenario:  Logged User could search for any product
    When user enter "Pride and Prejudice" in search box
#expected result
    Then search results shall appear

#Test Scenario 2: Logged user shall switch between currencies
  Scenario:  Logged User shall switch between currencies from US->Euro
    When user enter "Pride and Prejudice" in search box
    Then search results shall appear
#change currency: to $
    And user click on Currency dropdown list and choose US currency
#expected result
    Then validate dealing with US currency

#change currency: to euro
    And user click on Currency dropdown list and choose Euro currency
#expected result
    Then validate dealing with Euro currency
