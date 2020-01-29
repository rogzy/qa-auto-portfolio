package ru.rogzy.api.config;

import org.aeonbits.owner.Reloadable;

public interface Cfg extends Reloadable {

    @DefaultValue("https://reqres.in/api/")
    String url();

    @DefaultValue("false")
    @Key("debug.mode")
    boolean debugMode();
}
