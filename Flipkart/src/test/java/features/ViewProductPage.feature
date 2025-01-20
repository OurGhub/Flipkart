
@tag
Feature: Validate Product details Page

  @smoke
  Scenario: Validate product details Page
  
    Given user is on the View product page
    When user validate the name, price, discount and sellerinfo
    Then user click add to cart button