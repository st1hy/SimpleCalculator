package com.github.st1hy.simplecalculator.inject;

import com.github.st1hy.simplecalculator.control.KeypadController;
import com.github.st1hy.simplecalculator.control.MenuController;
import dagger.Binds;
import dagger.Module;
import dagger.multibindings.ClassKey;
import dagger.multibindings.IntoMap;

@Module
abstract class ControllersModule {

    @Binds @IntoMap @ClassKey(MenuController.class) abstract Object menuController(MenuController menuController);

    @Binds @IntoMap @ClassKey(KeypadController.class) abstract Object keypadController(KeypadController menuController);

}
