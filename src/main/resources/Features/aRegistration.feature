@smoke
Feature: User shall be able to register to the system

#Test Scenario 1
  Scenario:  User register with valid data
    Given user open browser for register
    And user navigates to register page
    When user enter valid data and click on register

#expected result
    Then user could register successfully