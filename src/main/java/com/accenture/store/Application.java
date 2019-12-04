package com.accenture.store;

import com.accenture.store.context.Context;
import com.accenture.store.model.Country;
import com.accenture.store.model.Item;
import com.accenture.store.model.Order;
import com.accenture.store.operations.custom.OrderSummaryOperation;
import com.accenture.store.operations.custom.TaxCalculationOperation;
import com.accenture.store.operations.OperationFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.ArrayList;

@SpringBootApplication
public class Application implements CommandLineRunner {
    @Autowired
    private OperationFactory factory;

    private static Logger LOG = LoggerFactory.getLogger(Application.class);

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Override
    public void run(String... args) {
        Context context = new Context();
        context.setOrder(createOrder());

        calculateValueForCountry(context, Country.POLAND);
        calculateValueForCountry(context, Country.NETHERLANDS);
    }

    private void calculateValueForCountry(Context context, Country country) {
        context.setCountry(country);
        factory.getOperation(OrderSummaryOperation.class, context).execute();
        factory.getOperation(TaxCalculationOperation.class, context).execute();
        DecimalFormat df = getDecimalFormat();
        LOG.info("Calculating for country: {}", context.getCountry());
        LOG.info("Order value: {} + {} = {}", df.format(context.getOrderValue()),
                df.format(context.getTax()),
                df.format(context.getTax().add(context.getOrderValue())));
    }

    private DecimalFormat getDecimalFormat() {
        DecimalFormat df = new DecimalFormat();
        df.setMaximumFractionDigits(2);
        df.setMinimumFractionDigits(0);
        df.setGroupingUsed(false);
        return df;
    }

    private Order createOrder() {
        Order order = new Order(new ArrayList<>());
        order.getItems().add(new Item(new BigDecimal("12.50")));
        order.getItems().add(new Item(new BigDecimal("50.50")));
        return order;
    }
}
