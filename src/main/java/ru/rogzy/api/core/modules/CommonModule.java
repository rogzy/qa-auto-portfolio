package ru.rogzy.api.core.modules;

import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import org.aeonbits.owner.ConfigCache;
import ru.rogzy.api.config.Cfg;
import ru.rogzy.api.net.NetSteps;
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
    public UsersRetrofit getReqResRetrofit(NetSteps steps, Cfg cfg) {
        return steps.createRetrofit(cfg, UsersRetrofit.class);
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
