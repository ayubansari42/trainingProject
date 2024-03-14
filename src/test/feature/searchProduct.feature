Feature: Search and Place the orders for Products
  @OffersPage
  Scenario Outline: Search Experience for product search in both home and Offers page

    Given User is on GreenCart Landing page
    When user searched with shortname <Name> and extracted actual name of product
    Then user searched for <Name> shortname in offers page to check if product exist with the same name
    And validate product name in offers page Matches with Landing Page

    Examples:
      | Name |  |
      | Tom  |  |
      | Beet |  |