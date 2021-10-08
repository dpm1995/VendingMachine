package com.techelevator;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class DrinkTest {

    private Drink target;

    @Before
    public void setup() {
        target = new Drink("C1");
    }

    @Test
    public void make_noise_returns_correct_noise(){
        Assert.assertTrue("Glug Glug, Yum!".equals(target.makeNoise()));
    }
    @Test
    public void get_name_returns_name(){
        Assert.assertTrue("Cola".equals(target.getName()));
    }
    @Test
    public void get_price_returns_price(){
        Assert.assertEquals(Double.valueOf(1.25),target.getPrice());
    }

}
