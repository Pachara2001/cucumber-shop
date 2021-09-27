Feature: Buy products
  As a user I want to buy products

  Background:
    Given a product "Latte" with price 40.00 exists
    And a product "Cookie" with price 20.00 exists

  Scenario Outline: Buy one product
    When I buy <product> with quantity <quantity>
    Then total should be <total>
    Examples:
      | product     | quantity |  total  |
      | "Latte"     |     1    |   40.00 |
      | "Cookie"    |     2    |  40.00  |