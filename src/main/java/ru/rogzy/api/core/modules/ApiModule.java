package ru.rogzy.api.core.modules;

import com.google.inject.AbstractModule;

public class ApiModule extends AbstractModule {

    @Override
    protected void configure() {
        this.install(new RequestModule());
        this.install(new ResponseModule());
        this.install(new CommonModule());
    }
}
