package com.accenture.store.model;

import java.math.BigDecimal;

public class Item {
    private BigDecimal price;

    public Item(BigDecimal price) {
        this.price = price;
    }

    public BigDecimal getPrice() {
        return price;
    }
}
