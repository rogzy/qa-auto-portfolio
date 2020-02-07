package ru.rogzy.api.core.modules;

import com.google.inject.AbstractModule;

public class ApiModule extends AbstractModule {

    @Override
    protected void configure() {
        this.install(new UsersModule());
        this.install(new ResourceModule());
        this.install(new RegisterModule());
        this.install(new LoginModule());
        this.install(new CommonModule());
    }
}
