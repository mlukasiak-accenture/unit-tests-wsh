package com.accenture.store.operations.custom;

import com.accenture.store.context.Context;
import com.accenture.store.model.SaleOrder;
import com.accenture.store.service.TaxService;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.ArrayList;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

class TaxCalculationOperationTest {

    @Test
    void shouldCalculateTax() {
        TaxService service = mock(TaxService.class);
        Context context = new Context();
        SaleOrder order = new SaleOrder(new ArrayList<>());

        when(service.calculateTax(eq(order), any())).thenReturn(BigDecimal.ZERO);

        context.setSaleOrder(order);
        TaxCalculationOperation operation = new TaxCalculationOperation(context, service);
        operation.execute();

        verify(service, times(1)).calculateTax(order, context);
        assertThat(context.getTax()).isEqualTo(BigDecimal.ZERO);
    }
}