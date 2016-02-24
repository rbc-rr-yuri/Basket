package com.rbc.rr;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.List;

interface BasketService {
    BigDecimal totalCost(List<List<Item>> baskets, HashSet<Class> allowedItems);
}

interface Item {
    BigDecimal getPrice();
}


class BasketItem implements Item {
  private BigDecimal price;

    public BasketItem(BigDecimal price) {
        if (price == null || price.intValue() < 0) throw new IllegalArgumentException("Price can't be negative");
        if (price.setScale(2, BigDecimal.ROUND_HALF_EVEN).compareTo(price) != 0 ) throw new IllegalArgumentException("Price should have only 2 decimals");
        this.price = price;
    }

    public BigDecimal getPrice() {
        return price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BasketItem that = (BasketItem) o;

        return price != null ? price.equals(that.price) : that.price == null;

    }

    @Override
    public int hashCode() {
        return price != null ? price.hashCode() : 0;
    }
}

class Banana extends BasketItem{

    public Banana(BigDecimal price) {
        super(price);
    }
}
class Orange extends BasketItem{
    public Orange(BigDecimal price) {
        super(price);
    }
}
class Apple extends BasketItem{
    public Apple(BigDecimal price) {
        super(price);
    }
}
class Lemon extends BasketItem{
    public Lemon(BigDecimal price) {
        super(price);
    }
}
class Peach extends BasketItem{
    public Peach(BigDecimal price) {
        super(price);
    }
}

class Car extends BasketItem{
    public Car(BigDecimal price) {
        super(price);
    }
}
