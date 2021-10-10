package com.techelevator;

public class Change {
    private AuditLog changeReturn = new AuditLog();
    private final String action = "GIVE CHANGE";
    private final double nickel = .05;
    private final double dime = .1;
    private final double quarter = .25;

    public Change() {}

    public double dispenseChange(double wallet){
        String changeDue;
        if (wallet % .1 != 0) {
            changeDue = String.valueOf(wallet) + "0";
            System.out.println("You have $" + wallet + "0 left in change.");
        } else {
            changeDue = String.valueOf(wallet);
            System.out.println("You have $" + wallet + " left in change.");
        }
        int nickelCount = 0;
        int dimeCount = 0;
        int quarterCount = 0;
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
