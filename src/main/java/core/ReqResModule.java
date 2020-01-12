package core;

import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import config.Cfg;
import org.aeonbits.owner.ConfigCache;
import requestes.CreateUserReq;
import requestes.UpdateUserReq;
import responses.CreateUserRes;
import responses.UpdateUserRes;
import responses.UserObjRes;
import responses.UserRes;
import retrofit.ReqResRetrofit;
import retrofit.Tech;
import utils.AutSteps;

public class ReqResModule extends AbstractModule {

    @Override
    protected void configure() {
    }

    @Provides
    public Cfg getConfig() {
        return ConfigCache.getOrCreate(Cfg.class, System.getenv(), System.getProperties());
    }

    @Provides
    public ReqResRetrofit getReqResRetrofit(Cfg cfg) {
        return Tech.createClient(cfg.url(), ReqResRetrofit.class);
    }

    @Provides
    public AutSteps getAutSteps() {
        return new AutSteps();
    }

    //request
    @Provides
    public CreateUserReq getCreateUserReq() {
        return new CreateUserReq();
    }

    @Provides
    public UpdateUserReq getUpdateUserReq() {
        return new UpdateUserReq();
    }

    //expected response
    @Provides
    public CreateUserRes getCreateUserRes() {
        return new CreateUserRes("Bob", "Unemployed");
    }

    @Provides
    public UpdateUserRes getUpdateUserRes() {
        return new UpdateUserRes("John", "Doctor");
    }

    @Provides
    public UserObjRes getUserObjRes() {
        return new UserObjRes(new UserRes());
    }
}
