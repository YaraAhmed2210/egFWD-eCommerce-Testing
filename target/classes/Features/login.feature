@smoke
Feature: User shall be able to login to the system and shall reset his/her password

  #background will be executed before each test scenario
Background: user open browser and navigates to login page
  Given user open browser
  And user navigates to login page

#Test Scenario 1
Scenario:  User login with valid username and password
#test steps
When user enter "yaraa2211@yahoo.com" and "123456" then click on login button
#expected result
Then user could login successfully to the home page


#Test Scenario 2
  Scenario:  User shall reset his/her password
#test steps
    When user click on forgot password
    And user redirected to reset page
    And user enter his valid mail then click recover button
#expected result
    Then reset mail should be sent to user

