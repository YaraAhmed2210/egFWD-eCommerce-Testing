@smoke
Feature: Logged User shall select different tags

Scenario: Logged user shall select different tags successfully

  Given user open the browser
  And user navigates to the login page
  And user enter "yaraa2211@yahoo.com" and "123456" then click on login btn
  Then user logged in successfully to the home page
  And user enter "First Prize Pies" in search box
  When user selects tag "awesome"
  Then user shall be directed to this tag "awesome" page
  And user selects tag "nice"
  Then user shall be directed to this tag "nice" page
