package com.accenture.store.operations.custom;

import com.accenture.store.context.Context;
import com.accenture.store.framework.BaseOperation;
import com.accenture.store.model.Item;
import com.accenture.store.model.SaleOrder;

import java.math.BigDecimal;

public class OrderSummaryOperation extends BaseOperation {

    public OrderSummaryOperation(Context context) {
        super(context);
    }

    public void doExecute() {
        SaleOrder saleOrder = this.getContext().getSaleOrder();
        if (saleOrder == null) {
            throw new IllegalStateException("No order in context.");
        }
        this.getContext().setOrderValue(saleOrder.getItems().stream()
                .map(Item::getPrice)
                .reduce(BigDecimal.ZERO, BigDecimal::add, BigDecimal::add));
    }
}
