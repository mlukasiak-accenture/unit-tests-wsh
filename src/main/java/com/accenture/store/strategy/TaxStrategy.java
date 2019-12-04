package com.accenture.store.strategy;

import com.accenture.store.model.Order;

import java.math.BigDecimal;

public interface TaxStrategy extends Strategy {
    BigDecimal calculateTax(Order order);
}
