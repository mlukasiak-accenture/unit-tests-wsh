package com.accenture.store.context;

import com.accenture.store.model.Country;
import com.accenture.store.model.Order;

import java.math.BigDecimal;

public class Context {
    private Country country;
    private Order   order;
    private BigDecimal tax;
    private BigDecimal orderValue;

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public BigDecimal getTax() {
        return tax;
    }

    public void setTax(BigDecimal tax) {
        this.tax = tax;
    }

    public BigDecimal getOrderValue() {
        return orderValue;
    }

    public void setOrderValue(BigDecimal orderValue) {
        this.orderValue = orderValue;
    }
}
