package com.techelevator;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;



public class CandyTest {

    private Candy target;

    @Before
    public void setup() {
        target = new Candy("B1");
    }

    @Test
    public void make_noise_returns_correct_noise(){
        Assert.assertTrue("Munch Munch, Yum!".equals(target.makeNoise()));
    }
    @Test
    public void get_name_returns_name(){
        Assert.assertTrue("Moonpie".equals(target.getName()));
    }
    @Test
    public void get_price_returns_price(){
        Assert.assertEquals(Double.valueOf(1.80),target.getPrice());
    }

}
