package com.accenture.store.operations.custom;

import com.accenture.store.context.Context;
import com.accenture.store.operations.OperationBuilder;
import org.springframework.stereotype.Component;

@Component
public class OrderSummaryOperationBuilder implements OperationBuilder {

    @Override
    public OrderSummaryOperation build(Context context) {
        return new OrderSummaryOperation(context);
    }

    @Override
    @SuppressWarnings("unchecked")
    public boolean isFor(Class operationType) {
        return operationType.isAssignableFrom(OrderSummaryOperation.class);
    }
}
