package com.accenture.store.operations.custom;

import com.accenture.store.context.Context;
import com.accenture.store.model.SaleOrder;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.ArrayList;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class OrderSummaryOperationTest {

    @Test
    void shouldCalculateTotalPriceForEmptyOrder() {
        Context context = new Context();
        SaleOrder order = new SaleOrder(new ArrayList<>());
        context.setSaleOrder(order);
        OrderSummaryOperation operation = new OrderSummaryOperation(context);
        operation.execute();

        assertThat(context.getOrderValue()).isEqualTo(BigDecimal.ZERO);
    }

    @Test
    void shouldThrowWhenNoOrderInContext() {
        Context context = new Context();
        OrderSummaryOperation operation = new OrderSummaryOperation(context);
        assertThatThrownBy(operation::execute)
                .isInstanceOf(IllegalStateException.class)
                .hasCause(null);
    }
}