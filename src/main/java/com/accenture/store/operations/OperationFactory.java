package com.accenture.store.operations;

import com.accenture.store.context.Context;
import com.accenture.store.framework.BaseOperation;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@SuppressWarnings("unchecked")
public class OperationFactory {
    private List<OperationBuilder> builders;

    public OperationFactory(List<OperationBuilder> builders) {
        this.builders = builders;
    }

    public <T extends BaseOperation> T getOperation(Class<T> operationType, Context context) {
        Optional<OperationBuilder> builder = builders.stream()
                .filter(potentialBuilder -> potentialBuilder.isFor(operationType))
                .findAny();
        if (builder.isPresent()) {
            return (T) builder.get().build(context);
        } else {
            throw new IllegalArgumentException("No builder for operation type: " + operationType.getSimpleName());
        }
    }

}
