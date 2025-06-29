Feature: Add product to cart

  Scenario: User adds a product to the cart
    Given The app is launched
    And The user logs in with "standard_user" and "secret_sauce"
    When The user taps on the first product
    And Adds the product to the cart
    Then The cart should contain the added product
