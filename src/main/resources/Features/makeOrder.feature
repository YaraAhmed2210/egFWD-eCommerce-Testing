@smoke
Feature: Logged User shall make order

  Scenario: Logged User shall make successful order

    Given user open the browser
    And user navigates to the login page
    And user enter "yaraa2211@yahoo.com" and "123456" then click on login btn
    Then user logged in successfully to the home page

    When user enter "First Prize Pies" in search box
    And user click on product "First Prize Pies"
    And user click on add to cart button
    Then product "First Prize Pies" shall be added to cart

    #When user enter "First Prize Pies" in search box
    #And user click on product "First Prize Pies"
    #And user click on add to cart button
    #Then product "First Prize Pies" shall be added to cart

    When click on agree on terms and checkout buttons
    And logged user shall fill Billing address section
    #And logged user shall fill shipping address section
    And logged user shall fill shipping method section
    And logged user shall fill payment method section
    And logged user shall fill payment Info section
    And logged user shall place order
    Then order should be completed

