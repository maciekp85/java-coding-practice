package com.barteczkobook.object_oriented_programming.initiations_and_singletons.singleton;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;

import static org.junit.Assert.*;

public class PriceListSingletonTest {

    private Double milkPrice = 3.00;
    private Double coffeePrice = 8.00;
    private String milk = "milk";
    private String coffee = "coffee";
    private HashMap<String, Double> map;
    private static Integer testNumber = 1;

    @Before
    public void setUp() {
        PriceList.INSTANCE.put("milk", milkPrice);
        PriceList.INSTANCE.put("coffee", coffeePrice);
        map = PriceList.INSTANCE;
    }

    @Test
    public void PriceList_CheckingPriceProducts_NothingReturnsOnlyAsserts() {
        assertNotNull(PriceList.INSTANCE);
        assertEquals(2, map.size());
        assertNotNull(PriceList.INSTANCE.get("milk"));
        assertNotNull(PriceList.INSTANCE.get("coffee"));
        assertNotNull(map.get("milk"));
        assertNotNull(map.get("coffee"));

        assertEquals(milkPrice, PriceList.INSTANCE.get("milk"));
        assertEquals(coffeePrice, PriceList.INSTANCE.get("coffee"));
        assertEquals(milkPrice, map.get("milk"));
        assertEquals(coffeePrice, map.get("coffee"));
    }

    @Test
    public void PriceList_CheckingProductPriceUsingSingletonInstanceAlsoAsHashMap_NothingReturnsOnlyAsserts() {
        milkPrice = PriceList.INSTANCE.get("milk") * 3;
        assertEquals("9.0", milkPrice.toString());

        coffeePrice = PriceList.INSTANCE.get("coffee") * 2;
        assertEquals("16.0", coffeePrice.toString());

        milkPrice = map.get(milk) / 3.0;
        assertNotEquals("3.0", milkPrice.toString());
        assertEquals("1.0", milkPrice.toString());

        coffeePrice = map.get(coffee) / 2;
        assertNotEquals("8.0", coffeePrice.toString());
        assertEquals("4.0", coffeePrice.toString());
    }

    @After
    public void tearDown() {
        System.out.println("Cleaning after " + PriceListSingletonTest.class.getSimpleName() + " " + testNumber++);
    }

}
