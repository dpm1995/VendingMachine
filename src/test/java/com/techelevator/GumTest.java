package com.techelevator;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


public class GumTest {

    private Gum target;

    @Before
    public void setup() {
        target = new Gum("D1");
    }

    @Test
    public void make_noise_returns_correct_noise(){
        Assert.assertTrue("Chew Chew, Yum!".equals(target.makeNoise()));
    }
    @Test
    public void get_name_returns_name(){
        Assert.assertTrue("U-Chews".equals(target.getName()));
    }
    @Test
    public void get_price_returns_price(){
        Assert.assertEquals(Double.valueOf(.85),target.getPrice());
    }

}
