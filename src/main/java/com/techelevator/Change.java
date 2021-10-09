package com.techelevator;

public class Change {
    private final double nickel = .05;
    private final double dime = .1;
    private final double quarter = .25;
    private int nickelCount = 0;
    private int dimeCount = 0;
    private int quarterCount = 0;

    public Change(double wallet) {
        System.out.println("You have \\$" + wallet + " left in change.");
        while (wallet > 0.0) {
            if (wallet > quarter) {
                wallet -= quarter;
                quarterCount++;
                continue;
            } else if (wallet > dime) {
                wallet -= dime;
                dimeCount++;
                continue;
            } else if (wallet > nickel) {
                wallet -= nickel;
                nickelCount++;
                continue;
            }
        }
        System.out.println("Your change will be dispensed as " + quarterCount +
                " quarters, " + dimeCount + " dimes, and " + nickelCount + " nickels.");
    }
}
