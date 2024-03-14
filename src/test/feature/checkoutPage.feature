Feature: Search and Place the orders for Products

  @PlaceOrder
  Scenario Outline: Search Experience for product search in both home and Offers page

    Given User is on GreenCart Landing page
    When user searched with shortname <Name> and extracted actual name of product
    And Added "3" for selected items to the cart
    Then user proceeds to checkout and validate the <Name> items in checkout page
    And Verify user has ability to enter promo code and place the order

    Examples:
      | Name |  |
      | Tom  |  |