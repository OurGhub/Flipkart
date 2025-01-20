@tag
Feature: Verify user Apply filters (e.g., brand, price range, ratings) in product page

  @tag1
  Scenario: User apply filters for searched product
    
    Given User is the product page
    When user apply brand, price and rating filter
    And Based on filter item will display
    Then user click First item in the list