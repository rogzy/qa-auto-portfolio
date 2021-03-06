package ru.rogzy.api.core.modules;

import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import ru.rogzy.api.aut.reqres.StateEnum;
import ru.rogzy.api.aut.reqres.resource.get_list.GetListResourceResponse;
import ru.rogzy.api.aut.reqres.resource.get_obj.GetSingleResourceResponse;
import ru.rogzy.api.core.annotations.api.NotExist;
import ru.rogzy.api.core.annotations.api.Single;

public class ResourceModule extends AbstractModule {

    @Override
    protected void configure() {
    }

    @Provides
    public GetListResourceResponse getListResourceResponse() {
        return new GetListResourceResponse();
    }

    @Provides
    @NotExist
    public GetSingleResourceResponse getNotExistResourceResponse() {
        return new GetSingleResourceResponse(StateEnum.NOT_EXIST);
    }

    @Provides
    @Single
    public GetSingleResourceResponse getSingleResourceResponse() {
        return new GetSingleResourceResponse(StateEnum.SINGLE);
    }

}
