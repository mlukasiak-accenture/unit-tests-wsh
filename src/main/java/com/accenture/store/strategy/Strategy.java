package com.accenture.store.strategy;

import com.accenture.store.context.Context;

public interface Strategy {
    boolean isApplicable(Context context);
}
