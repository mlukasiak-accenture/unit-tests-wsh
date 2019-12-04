package com.accenture.store.model;

import java.util.List;

public class SaleOrder {
    private List<Item> items;

    public SaleOrder(List<Item> items) {
        this.items = items;
    }

    public List<Item> getItems() {
        return items;
    }
}
