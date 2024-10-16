# QE-Coffee-Shop-Interview-Problem
## Problem
We are tasked with writing a new coffee shop cash registry's simple code

There are 4 items on the menu:
* Espresso - £1.80
* Tea - £2.20
* Latte - £2.60
* Cappuccino - £2.85

As part of the new grand opening, the owners want to also add some extra offers:
* Buy 2 Espressos, get 3rd Half Price (i.e. 3 espresso = £4.50 instead of £5.40), this accumulates, which means, for 6 espressos, 2 of them are half priced
* The Milk Duo: If you get a Latte and a Cappuccino, the bill will have a 5% discount on the whole bill

Write the code for these conditions and also write the tests in Gherkin/Cucumber
## Input

The input will be the order represented by 4 integers, these will be in this order:
1. Number of Espresso
2. Number of Tea
3. Number of Latte
4. Number of Cappuccino

## Output
And the output will be a double representing the price of the order, represented with two decimal values (if there are more decimal values, you can just ignore them or round the value)

## Examples:

| Input        | Output |
|--------------|--------|
| `3, 0, 0, 0` | `4.50` |
| `1, 1, 1, 1` | `8.97` |
| `1, 1, 1, 0` | `6.60` |
| `3, 0, 1, 1` | `9.45` |

## Build

```
./gradlew build
```

## Running tests

```
./gradlew acceptanceTests
```