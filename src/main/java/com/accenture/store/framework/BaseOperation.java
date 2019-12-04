package com.accenture.store.framework;

import com.accenture.store.context.Context;

// We are not allowed to touch it
public abstract class BaseOperation {
    protected Context context;

    public BaseOperation(Context context) {
        this.context = context;
    }

    public Context getContext() {
        return context;
    }

    public final void execute() {
        preExecute();
        doExecute();
        postExecute();
    }

    protected abstract void doExecute();

    protected void preExecute() {
        // To be implemented by subclasses.By default do nothing.
    }

    protected void postExecute() {
        // To be implemented by subclasses. By default do nothing.
    }
}
