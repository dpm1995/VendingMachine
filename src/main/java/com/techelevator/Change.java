package com.techelevator;

import java.math.BigDecimal;
import java.text.NumberFormat;

public class Change {
    private AuditLog changeReturn = new AuditLog();
    private NumberFormat dollar = NumberFormat.getCurrencyInstance();
    private final String action = "GIVE CHANGE";
    private final Double nickel = .05;
    private final Double dime = .1;
    private final Double quarter = .25;

    public Change() {}

    public double dispenseChange(Double wallet){
        BigDecimal finalWallet = new BigDecimal("0.00");
        String changeDue = "GIVE CHANGE";
        System.out.println("You have " + dollar.format(wallet) + " left in change.");
        int nickelCount = 0;
        int dimeCount = 0;
        int quarterCount = 0;
        while (wallet > 0.0) {
            if (wallet > quarter) {
                wallet -= quarter;
                quarterCount++;
                Math.round(wallet);
                continue;
            } else if (wallet > dime) {
                wallet -= dime;
                dimeCount++;
                Math.round(wallet);
                continue;
            } else if (wallet > nickel) {
                wallet -= nickel;
                nickelCount++;
                Math.round(wallet);
                continue;
            } else {
                wallet = 0.0;
                break;
            }
        }
        System.out.println("Your change will be dispensed as " + quarterCount +
                " quarters, " + dimeCount + " dimes, and " + nickelCount + " nickels.");
        changeReturn.logEvent(action, changeDue, "0.00");
        return wallet;
    }
}
