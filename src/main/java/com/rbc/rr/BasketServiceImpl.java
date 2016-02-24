package com.rbc.rr;

import java.math.BigDecimal;
import java.util.List;

/**
 * Holds utility methods for basket
 */
public class BasketServiceImpl implements BasketService {

    /**
     * Performs calculation of the total cost of all iteams in basket
     */
    public BigDecimal totalCost(List<List<Item>> baskets) {
        BigDecimal totalCost = new BigDecimal(0);
        if (baskets != null) {
            for (List<Item> basket : baskets) {
                for (Item item : basket) {
                    totalCost = totalCost.add(item.getPrice());
                }
            }
        }
        return totalCost.setScale(2, BigDecimal.ROUND_HALF_EVEN);
    }
}
