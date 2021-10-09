package com.techelevator;

import java.io.PrintWriter;
import java.util.Scanner;

public class AuditLog {
    InventoryReader itemAudits = new InventoryReader();
    Scanner logPrepper = new Scanner(); //Fix both of these scanners, build a string for each transaction
    PrintWriter logWriter = new PrintWriter(); //That string gets passed to a method in this class
                                               //Which writes out the full string to the log.txt file.0
    public AuditLog(){                         //Boolean sale validation is here

    }

    public boolean validSale(double wallet, double salePrice, int stock){ //Verifies sale.
        return wallet > salePrice && stock > 0;
    }
}
