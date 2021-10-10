package com.techelevator;

import org.junit.Assert;
import org.junit.Test;

public class ChangeTest {

    @Test
    public void get_correct_change(){
        //Arrange
        Change dispenser = new Change();

        //Act
        double changeGiven = dispenser.dispenseChange(.90);

        //Assert
        Assert.assertEquals(0.0, dispenser);
    }
}
