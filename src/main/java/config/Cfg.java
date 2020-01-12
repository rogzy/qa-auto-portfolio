package config;

import org.aeonbits.owner.Config;

public interface Cfg extends Config {

    @DefaultValue("https://reqres.in/api/")
    String url();
}
