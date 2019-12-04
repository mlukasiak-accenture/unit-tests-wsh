package com.accenture.store.operations.custom;

import com.accenture.store.context.Context;
import com.accenture.store.framework.BaseOperation;
import com.accenture.store.model.Item;
import com.accenture.store.model.Order;

import java.math.BigDecimal;

public class OrderSummaryOperation extends BaseOperation {

    public OrderSummaryOperation(Context context) {
        super(context);
    }

    public void doExecute() {
        Order order = this.getContext().getOrder();
        this.getContext().setOrderValue(order.getItems().stream()
                .map(Item::getPrice)
                .reduce(BigDecimal.ZERO, BigDecimal::add, BigDecimal::add));
    }
}
