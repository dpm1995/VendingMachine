package com.techelevator;

import org.junit.*;


public class ChipTest {

    private Chip target;

    @Before
    public void setup() {
        target = new Chip("A1");
    }

    @Test
    public void make_noise_returns_correct_noise(){
        Assert.assertTrue("Crunch Crunch, Yum!".equals(target.makeNoise()));
    }
    @Test
    public void get_name_returns_name(){
        Assert.assertTrue("Potato Crisps".equals(target.getName()));
    }
    @Test
    public void get_price_returns_price(){
        Assert.assertEquals(Double.valueOf(3.05),target.getPrice());
    }

}
