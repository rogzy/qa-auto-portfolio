package ru.rogzy.api.config;

import org.aeonbits.owner.Reloadable;

public interface Cfg extends Reloadable {

    @DefaultValue("https://reqres.in/api/")
    String apiUrl();

    @DefaultValue("https://www.wiley.com/en-us")
    String webUrl();

    @DefaultValue("Java")
    String textForSearch();

    @DefaultValue("false")
    @Key("debug.mode")
    boolean debugMode();
}
