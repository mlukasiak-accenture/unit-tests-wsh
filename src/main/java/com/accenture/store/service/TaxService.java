/*
 * Copyright (C) Siever Consulting B.V.
 * 2019, All rights reserved.
 */


package com.accenture.store.service;

import com.accenture.store.context.Context;
import com.accenture.store.model.Order;
import com.accenture.store.strategy.TaxStrategy;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Optional;
import java.util.Set;

@Service
public class TaxService {
    private final Set<TaxStrategy> taxStrategies;

    public TaxService(Set<TaxStrategy> taxStrategies) {
        this.taxStrategies = taxStrategies;
    }

    public BigDecimal calculateTax(Order order, Context context) {
        Optional<TaxStrategy> taxStrategy = taxStrategies.stream()
                .filter(strategy -> strategy.isApplicable(context))
                .findAny();
        if (taxStrategy.isPresent()) {
            return taxStrategy.get().calculateTax(order);
        } else {
            throw new IllegalArgumentException("Tax calculation not available for country: " + context.getCountry());
        }
    }
}
