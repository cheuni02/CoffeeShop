package org.cheuni02;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class CoffeeShopCalcStepdefs {
    private final CoffeeShopCalc coffeeShopCalc = new CoffeeShopCalc();
    private int quantityEspresso, quantityTea, quantityLatte, quantityCappuccino;
    private String actualErrMsg;

    @When("^I buy (-?\\d+) (\\w+)$")
    public void iBuyItem(int quantity, String item) {
        switch (item) {
            case "Espresso":
                quantityEspresso = quantity;
                break;
            case "Tea":
                quantityTea = quantity;
                break;
            case "Latte":
                quantityLatte = quantity;
                break;
            case "Cappuccino":
                quantityCappuccino = quantity;
                break;
            default:
                throw new IllegalArgumentException("we don't sell this item: " + item);
        }
    }

    @Then("I am charged {double}")
    public void iAmChargedPrice(double price) {
        double total = coffeeShopCalc.priceToPay(quantityEspresso, quantityTea, quantityLatte, quantityCappuccino);
        assertEquals(price, total);
    }

    @Given("I am not ordering anything")
    public void iAmNotOrderingAnything() {
        quantityEspresso = 0;
        quantityTea = 0;
        quantityLatte = 0;
        quantityCappuccino = 0;
    }

    @Then("I should not be charged")
    public void iShouldNotBeCharged() {
        iAmChargedPrice(0.0);
    }

    @Then("I will be shown an error {string}")
    public void iWillBeShownAnErrorError(String expectedErrorMsg) {
        try {
            coffeeShopCalc.priceToPay(quantityEspresso, quantityTea, quantityLatte, quantityCappuccino);
        } catch (IllegalArgumentException e) {
            actualErrMsg = e.getMessage();
        }
        assertEquals(expectedErrorMsg, actualErrMsg);
    }
}
