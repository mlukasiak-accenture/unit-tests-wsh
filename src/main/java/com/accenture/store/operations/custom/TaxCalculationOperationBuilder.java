package com.accenture.store.operations.custom;

import com.accenture.store.context.Context;
import com.accenture.store.operations.OperationBuilder;
import com.accenture.store.service.TaxService;
import org.springframework.stereotype.Component;

@Component
public class TaxCalculationOperationBuilder implements OperationBuilder {
    private final TaxService taxService;

    public TaxCalculationOperationBuilder(TaxService taxService) {
        this.taxService = taxService;
    }

    @Override
    public TaxCalculationOperation build(Context context) {
        return new TaxCalculationOperation(context, taxService);
    }

    @Override
    @SuppressWarnings("unchecked")
    public boolean isFor(Class operationType) {
        return operationType.isAssignableFrom(TaxCalculationOperation.class);
    }
}
