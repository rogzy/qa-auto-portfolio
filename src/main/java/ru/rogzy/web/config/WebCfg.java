package ru.rogzy.web.config;

import org.aeonbits.owner.Reloadable;

public interface WebCfg extends Reloadable {
    @DefaultValue("https://www.wiley.com/en-us")
    String webUrl();

    @DefaultValue("Java")
    String textForSearch();
}
