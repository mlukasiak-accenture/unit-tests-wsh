package com.accenture.store.context;

import com.accenture.store.model.Country;
import com.accenture.store.model.SaleOrder;

import java.math.BigDecimal;

public class Context {
    private Country country;
    private SaleOrder saleOrder;
    private BigDecimal tax;
    private BigDecimal orderValue;

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public SaleOrder getSaleOrder() {
        return saleOrder;
    }

    public void setSaleOrder(SaleOrder saleOrder) {
        this.saleOrder = saleOrder;
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
