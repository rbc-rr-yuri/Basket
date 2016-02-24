package com.rbc.rr;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

/**
 * Holds utility methods for basket
 */
public class BasketServiceImpl implements BasketService {

    /**
     * Performs calculation of the total cost of all iteams in basket
     */
    public BigDecimal totalCost(List<List<Item>> baskets, HashSet<Class> allowedItems) {
        BigDecimal totalCost = new BigDecimal(0);
        if (baskets != null) {
            for (List<Item> basket : baskets) {
                for (Item item : basket) {
                    if (allowedItems != null && allowedItems.contains(item.getClass())){
                        totalCost = totalCost.add(item.getPrice());
                    } else
                        throw new IllegalArgumentException("Basket can't have the items of type :" + item.getClass().getSimpleName());
                }
            }
        }
        return totalCost.setScale(2, BigDecimal.ROUND_HALF_EVEN);
    }
}
