package com.accenture.store.operations;

import com.accenture.store.context.Context;
import com.accenture.store.framework.BaseOperation;

public interface OperationBuilder<T extends BaseOperation> {
    T build(Context context);

    boolean isFor(Class<? extends BaseOperation> operationType);
}
