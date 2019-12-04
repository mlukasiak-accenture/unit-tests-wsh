package com.accenture.store.strategy;

import com.accenture.store.model.SaleOrder;

import java.math.BigDecimal;

public interface TaxStrategy extends Strategy {
    BigDecimal calculateTax(SaleOrder saleOrder);
}
