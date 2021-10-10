package com.techelevator;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class AuditLogTest {

    AuditLog audits = new AuditLog();


    @Test
    public void log_insert_money_properly(){
        //Arrange
        //Act
        String newLine = audits.logEvent("FEED MONEY", "5.00", "10.00");

        //Assert
        Assert.assertEquals("10/09/2021 06:06:25 FEED MONEY \\$5.00 \\$10.00", newLine);
    }

    @Test
    public void log_sale_properly(){
        //Arrange
        Transaction testSale = new Transaction(5.0);
        testSale.Purchase(5.0);

        //Act
        String saleLine = audits.logEvent("Cowtales B2", "5.00", "3.50");

        //Assert
        Assert.assertEquals("10/09/21 06:49:20 Cowtales B2 \\$5.00 \\$3.50", saleLine);
    }

    @Test
    public void log_change_properly(){
        //Arrange
        Change dispense = new Change();
        dispense.dispenseChange(4.00);

        //Act
        String changeLine = audits.logEvent("GIVE CHANGE", "4.00", "0.00");

        //Assert
        Assert.assertEquals("10/09/21 07:02:25 GIVE CHANGE \\$4.00 \\$0.00", changeLine);
    }
}
