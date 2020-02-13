package ru.rogzy.api.core.modules;

import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import org.aeonbits.owner.ConfigCache;
import ru.rogzy.api.config.ApiCfg;
import ru.rogzy.api.net.NetSteps;
import ru.rogzy.api.retrofit.LoginRetrofit;
import ru.rogzy.api.retrofit.RegisterRetrofit;
import ru.rogzy.api.retrofit.ResourceRetrofit;
import ru.rogzy.api.retrofit.UsersRetrofit;
import ru.rogzy.api.util.UtilSteps;
import ru.rogzy.web.config.WebCfg;

public class CommonModule extends AbstractModule {

    @Override
    protected void configure() {
    }

    @Provides
    public ApiCfg getApiConfig() {
        ApiCfg cfg = ConfigCache.getOrCreate(ApiCfg.class, System.getenv(), System.getProperties());
        cfg.reload();
        return cfg;
    }

    @Provides
    public WebCfg getWebConfig() {
        WebCfg cfg = ConfigCache.getOrCreate(WebCfg.class, System.getenv(), System.getProperties());
        cfg.reload();
        return cfg;
    }

    @Provides
    public UsersRetrofit getUsersRetrofit(NetSteps steps, ApiCfg cfg) {
        return steps.createRetrofit(cfg, UsersRetrofit.class);
    }

    @Provides
    public ResourceRetrofit getResourceRetrofit(NetSteps steps, ApiCfg cfg) {
        return steps.createRetrofit(cfg, ResourceRetrofit.class);
    }

    @Provides
    public RegisterRetrofit getRegisterRetrofit(NetSteps steps, ApiCfg cfg) {
        return steps.createRetrofit(cfg, RegisterRetrofit.class);
    }

    @Provides
    public LoginRetrofit getLoginRetrofit(NetSteps steps, ApiCfg cfg) {
        return steps.createRetrofit(cfg, LoginRetrofit.class);
    }

    @Provides
    public NetSteps getNetSteps() {
        return new NetSteps();
    }

    @Provides
    public UtilSteps getCheckSteps() {
        return new UtilSteps();
    }
}
