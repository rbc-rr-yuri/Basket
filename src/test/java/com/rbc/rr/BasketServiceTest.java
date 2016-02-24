package com.rbc.rr;

import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class BasketServiceTest {
    BasketService service;

    @Before
    public void setUp(){
        service = new BasketServiceImpl();
    }

    @Test
    public void testTotalCost4SingleBasket() {
        List<Item> basket1 = new ArrayList<Item>();
        basket1.add(new Orange(new BigDecimal("2.5")));
        basket1.add(new Banana(new BigDecimal("1.5")));
        basket1.add(new Banana(new BigDecimal("1.55")));
        basket1.add(new Apple(new BigDecimal("4.9")));
        basket1.add(new Apple(new BigDecimal("5.11")));

        ArrayList<List<Item>> baskets = new ArrayList<List<Item>>();
        baskets.add(basket1);

        BigDecimal totalCost = service.totalCost(baskets);

        assertEquals(new BigDecimal(15.56).setScale(2, RoundingMode.HALF_EVEN), totalCost);

    }

    @Test
    public void testTotalCost4MultipleBaskets() {
        List<Item> basket1 = new ArrayList<Item>();
        basket1.add(new Orange(new BigDecimal("2.5")));
        basket1.add(new Banana(new BigDecimal("1.5")));
        basket1.add(new Banana(new BigDecimal("1.55")));
        basket1.add(new Apple(new BigDecimal("4.9")));
        basket1.add(new Apple(new BigDecimal("5.11")));

        ArrayList<List<Item>> baskets = new ArrayList<List<Item>>();
        baskets.add(basket1);
        baskets.add(basket1);
        baskets.add(basket1);

        BigDecimal totalCost = service.totalCost(baskets);

        assertEquals(new BigDecimal(15.56*3).setScale(2, RoundingMode.HALF_EVEN), totalCost);

    }

    @Test
    public void testTotalCost4EmptyBasket() {
        assertEquals(BigDecimal.ZERO.setScale(2), service.totalCost(null));
        assertEquals(BigDecimal.ZERO.setScale(2), service.totalCost(new ArrayList<List<Item>>()));
    }

    @Test(expected=IllegalArgumentException.class)
    public void testBasketItemPriceWithManyDecimals() {
        new Orange(new BigDecimal("2.5234"));
    }

    @Test(expected=IllegalArgumentException.class)
    public void testBasketItemNegativePrice() {
        new Orange(new BigDecimal("-2.5234"));
    }

}