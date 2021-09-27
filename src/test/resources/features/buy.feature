Feature: Buy products
    As a customer
    I want to buy products

Background:
    Given a product "Bread" with price 20.00 exists and quantity 5
    And a product "Jam" with price 80.00 exists
    And a product "Butter" with price 10.00 exists

Scenario: Buy one product
    When I buy "Bread" with quantity 2
    Then total should be 40.00

Scenario: Buy multiple products
    When I buy "Bread" with quantity 2
    And I buy "Jam" with quantity 1
    And I buy "Butter" with quantity 2
    Then total should be 140.00

Scenario: Buy three products
    When I buy "Butter" with quantity 2
    And I buy "Jam" with quantity 3
    And I buy "Bread" with quantity 4
    Then total should be 340.00

    Scenario: Buy product with not enough quantity
        When I buy "Bread" with not enough quantity 200
        Then total should be 0
