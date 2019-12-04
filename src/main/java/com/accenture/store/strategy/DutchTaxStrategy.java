package com.accenture.store.strategy;

import com.accenture.store.context.Context;
import com.accenture.store.model.Country;
import com.accenture.store.model.Order;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class DutchTaxStrategy implements TaxStrategy {
    private static BigDecimal VAT = new BigDecimal("0.21");

    public BigDecimal calculateTax(Order order) {
        return order.getItems().stream().map(item -> item.getPrice().multiply(VAT)).reduce(BigDecimal.ZERO, BigDecimal::add, BigDecimal::add);
    }

    public boolean isApplicable(Context context) {
        return context.getCountry() == Country.NETHERLANDS;
    }
}
