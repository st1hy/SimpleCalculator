package com.github.st1hy.simplecalculator.inject;

import com.github.st1hy.simplecalculator.MainApp;
import dagger.BindsInstance;
import dagger.Component;


@PerApp @Component(modules = MainModule.class)
public interface MainComponent {

    void inject(MainApp app);

    @Component.Builder interface Builder {

        @BindsInstance Builder mainApp(MainApp app);

        MainComponent build();
    }
}
