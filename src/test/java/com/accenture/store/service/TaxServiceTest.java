package com.accenture.store.service;

import com.accenture.store.context.Context;
import com.accenture.store.model.SaleOrder;
import com.accenture.store.strategy.TaxStrategy;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class TaxServiceTest {

    private static final BigDecimal TEST_TAX = new BigDecimal("44");
    private TaxStrategy strategy;
    private Set<TaxStrategy> strategies;
    private Context context;
    private SaleOrder order;

    @BeforeEach
    void setup() {
        this.strategy = mock(TaxStrategy.class);
        strategies = new HashSet<>();
        strategies.add(strategy);
        context = mock(Context.class);
        order = mock(SaleOrder.class);
    }

    @Test
    void shouldCalculateTaxUsingStrategy() {
        when(strategy.isApplicable(context)).thenReturn(true);
        when(strategy.calculateTax(order)).thenReturn(TEST_TAX);

        TaxService service = new TaxService(strategies);
        BigDecimal tax = service.calculateTax(order, context);

        assertThat(tax).isEqualTo(TEST_TAX);
    }

    @Test
    void shouldThrowWhenNoStrategyFound() {
        when(strategy.isApplicable(context)).thenReturn(false);

        TaxService service = new TaxService(strategies);

        assertThatThrownBy(() -> service.calculateTax(order, context))
                .isInstanceOf(IllegalArgumentException.class);
    }

}