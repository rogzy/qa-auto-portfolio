package ru.rogzy.api.core.modules;

import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import org.aeonbits.owner.ConfigCache;
import ru.rogzy.api.config.Cfg;
import ru.rogzy.api.net.NetSteps;
import ru.rogzy.api.retrofit.LoginRetrofit;
import ru.rogzy.api.retrofit.RegisterRetrofit;
import ru.rogzy.api.retrofit.ResourceRetrofit;
import ru.rogzy.api.retrofit.UsersRetrofit;
import ru.rogzy.api.util.UtilSteps;

public class CommonModule extends AbstractModule {

    @Override
    protected void configure() {
    }

    @Provides
    public Cfg getConfig() {
        Cfg cfg = ConfigCache.getOrCreate(Cfg.class, System.getenv(), System.getProperties());
        cfg.reload();
        return cfg;
    }

    @Provides
    public UsersRetrofit getUsersRetrofit(NetSteps steps, Cfg cfg) {
        return steps.createRetrofit(cfg, UsersRetrofit.class);
    }

    @Provides
    public ResourceRetrofit getResourceRetrofit(NetSteps steps, Cfg cfg) {
        return steps.createRetrofit(cfg, ResourceRetrofit.class);
    }

    @Provides
    public RegisterRetrofit getRegisterRetrofit(NetSteps steps, Cfg cfg) {
        return steps.createRetrofit(cfg, RegisterRetrofit.class);
    }

    @Provides
    public LoginRetrofit getLoginRetrofit(NetSteps steps, Cfg cfg) {
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
