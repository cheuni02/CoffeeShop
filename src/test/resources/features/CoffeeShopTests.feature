Feature: As a Coffee Shop Owner
  I want to be able to make sure the total price of the order is correct
  According to the number of items ordered and the discounts granted
  By a customer at any one order.

  Scenario: I am not charged if not ordering anything
    Given I am not ordering anything
    Then I should not be charged

  Scenario Outline: Standard prices for single purchases
    When I buy 1 <item>
    Then I am charged <price>

    Examples:
      | item       | price |
      | Espresso   | 1.80  |
      | Tea        | 2.20  |
      | Latte      | 2.60  |
      | Cappuccino | 2.85  |

  Scenario Outline: (Case Study: Espresso) For every 3rd order of Espresso you will get one half price
    When I buy <number> Espresso
    Then I am charged <price>

    Examples:
      | number | price |
      | 2      | 3.60  |
      | 3      | 4.50  |
      | 4      | 6.30  |
      | 5      | 8.10  |
      | 6      | 9     |
      | 7      | 10.80 |
      | 8      | 12.60 |

  Scenario Outline: 5% discount whole bill if order contains at least one latte and one cappuccino
    When I buy <numLatte> Latte
    And I buy <numCappuccino> Cappuccino
    And I buy <numTea> Tea
    And I buy <numEspresso> Espresso
    Then I am charged <price>

    Examples:
      | numLatte | numCappuccino | numTea | numEspresso | price |
      | 0        | 0             | 1      | 1           | 4.00  |
      | 1        | 0             | 1      | 1           | 6.60  |
      | 0        | 1             | 1      | 1           | 6.85  |
      | 1        | 1             | 1      | 1           | 8.98  |
      | 1        | 1             | 0      | 0           | 5.18  |
      | 1        | 2             | 0      | 0           | 7.89  |
      | 2        | 2             | 0      | 0           | 10.36 |
      | 2        | 2             | 2      | 2           | 17.95 |
      | 4        | 4             | 10     | 10          | 56.14 |

  Scenario Outline: Coffee shop owner cannot accidentally punch in negative numbers for quantities
    When I buy <numLatte> Latte
    And I buy <numCappuccino> Cappuccino
    And I buy <numTea> Tea
    And I buy <numEspresso> Espresso
    Then I will be shown an error "Quantities must be positive"

    Examples:
      | numLatte | numCappuccino | numTea | numEspresso |
      | -1       | 0             | 0      | 0           |
      | -1       | -4            | 0      | 1           |
      | 0        | 1             | -5     | 1           |
      | 1        | 1             | 1      | -6          |
      | -1       | -1            | 0      | 0           |
      | 1        | -2            | 0      | 0           |
      | 2        | 2             | -1     | -2          |
      | 2        | -2            | -2     | -2          |
      | -4       | -4            | -10    | -10         |


# Qs to the product owner

# 1) is there a limit to how much one can order at any one order?
# 2) can the coffee shop owner accidentally punch in non numerics for order quantities? if so there will be a scenario similar to the one above