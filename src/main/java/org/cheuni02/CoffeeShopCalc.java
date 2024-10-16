package org.cheuni02;

import java.util.Arrays;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class CoffeeShopCalc {

    public static double roundToNumDecimalPlaces(double val, int decimalPlaces) {
        double scale = Math.pow(10, decimalPlaces);
        return Math.round(val * scale) / scale;
    }

    public double priceToPay(int... quantities) {

        if (quantities.length > 4) throw new IllegalArgumentException("Too many quantities");
        if (Arrays.stream(quantities).anyMatch(quantity -> quantity < 0)) {
            throw new IllegalArgumentException("Quantities must be positive");
        }

        // Coffee prices
        double pricePerEspresso = 1.80;
        double pricePerTea = 2.20;
        double pricePerLatte = 2.60;
        double pricePerCuppa = 2.85;

        // Offer One: Buy 2 Espressos, get 3rd Half Price (i.e. 3 espresso = £4.50 instead of £5.40), this accumulates, which means, for 6 espressos, 2 of them are half priced
        double offerOneDeductions = (int) ((double) quantities[0] / 3) * (pricePerEspresso / 2);

        // Offer Two: The Milk Duo: If you get a Latte and a Cappuccino, the bill will have a 5% discount on the whole bill
        double offerTwoDeductions = 1.0;
        if (quantities[2] > 0 && quantities[3] > 0) offerTwoDeductions = 0.95; //5% off total

        double totalWithDeductions = ((quantities[0] * pricePerEspresso) +
                (quantities[1] * pricePerTea) +
                (quantities[2] * pricePerLatte) +
                (quantities[3] * pricePerCuppa) -
                offerOneDeductions) * offerTwoDeductions;

        return roundToNumDecimalPlaces(totalWithDeductions, 2);
    }
}