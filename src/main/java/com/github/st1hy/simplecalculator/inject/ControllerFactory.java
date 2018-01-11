package com.github.st1hy.simplecalculator.inject;

import javafx.util.Callback;

import javax.inject.Inject;
import javax.inject.Provider;
import java.util.Map;

class ControllerFactory implements Callback<Class<?>, Object> {

    private final Map<Class<?>, Provider<Object>> controllers;

    @Inject
    ControllerFactory(Map<Class<?>, Provider<Object>> controllers) {
        this.controllers = controllers;
    }

    @Override public Object call(Class<?> param) {
        Provider<Object> controllerProvider = controllers.get(param);
        if (controllerProvider == null) throw new NullPointerException("No controller found for " + param.getName());
        return controllerProvider.get();
    }
}
