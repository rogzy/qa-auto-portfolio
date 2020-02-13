package ru.rogzy.api.config;

import org.aeonbits.owner.Reloadable;

public interface ApiCfg extends Reloadable {

    @DefaultValue("https://reqres.in/api/")
    String apiUrl();

    @DefaultValue("false")
    @Key("debug.mode")
    boolean debugMode();
}
