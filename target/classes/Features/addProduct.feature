@smoke
Feature: Logged user shall add product to shopping cart/wishlist/comparelist
Background:
    Given user open the browser
    And user navigates to the login page
    And user enter "yaraa2211@yahoo.com" and "123456" then click on login btn
    Then user logged in successfully to the home page


#Test Scenario 1: Logged user shall add different products to shopping cart //done
  Scenario:  Logged User shall add different products to shopping cart
    #first product
    When user enter "First Prize Pies" in search box
    And user click on product "First Prize Pies"
    And user click on add to cart button
    Then product "First Prize Pies" shall be added to cart
    #second product
    When user enter "Flower Girl Bracelet" in search box
    And user click on product "Flower Girl Bracelet"
    And user click on add to cart button
    Then product "Flower Girl Bracelet" shall be added to cart



#Test Scenario 2: Logged user shall add different products to wishlist //done
  Scenario:  Logged User shall add different products to wishlist
    #first product
    When user enter "First Prize Pies" in search box
    And user click on product "First Prize Pies"
    And user click on add to wishlist button
    Then product "First Prize Pies" shall be added to wishlist
    #second product
    When user enter "Flower Girl Bracelet" in search box
    And user click on product "Flower Girl Bracelet"
    And user click on add to wishlist button
    Then product "Flower Girl Bracelet" shall be added to wishlist


#Test Scenario 3: Logged user shall add different products to compareList //done
  Scenario:  Logged User shall add different products to compareList
    #first product
    When user enter "First Prize Pies" in search box
    And user click on product "First Prize Pies"
    And user click on add to compareList button
    Then product "First Prize Pies" shall be added to compareList
    #second product
    When user enter "Flower Girl Bracelet" in search box
    And user click on product "Flower Girl Bracelet"
    And user click on add to compareList button
    Then product "Flower Girl Bracelet" shall be added to compareList