package ru.rogzy.api.core.modules;

import com.google.inject.AbstractModule;

public class WebModule extends AbstractModule {

    @Override
    protected void configure() {
        this.install(new CommonModule());
    }
}
