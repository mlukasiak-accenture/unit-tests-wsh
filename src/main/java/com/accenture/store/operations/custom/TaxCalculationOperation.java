
package com.accenture.store.operations.custom;

import com.accenture.store.context.Context;
import com.accenture.store.framework.BaseOperation;
import com.accenture.store.model.Order;
import com.accenture.store.service.TaxService;

public class TaxCalculationOperation extends BaseOperation {
    private final TaxService taxService;

    public TaxCalculationOperation(Context context, TaxService taxService) {
        super(context);
        this.taxService = taxService;
    }

    public void doExecute() {
        Order order = this.getContext().getOrder();
        this.getContext().setTax(taxService.calculateTax(order, getContext()));
    }
}
