package api.component.reqres;

import com.google.inject.Inject;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import retrofit2.Response;
import ru.rogzy.api.aut.reqres.resource.get_list.GetListResourceResponse;
import ru.rogzy.api.aut.reqres.resource.get_obj.GetSingleResourceResponse;
import ru.rogzy.api.core.annotations.api.Api;
import ru.rogzy.api.core.annotations.api.NotExist;
import ru.rogzy.api.core.annotations.api.Single;
import ru.rogzy.api.net.NetSteps;
import ru.rogzy.api.retrofit.ResourceRetrofit;
import ru.rogzy.api.util.UtilSteps;

@Api
public class ResourceTests {

    @Inject
    UtilSteps utilSteps;

    @Test
    @DisplayName("Получение информации о списке ресурсов")
    void getListResourcesTest(ResourceRetrofit api,
                              NetSteps steps,
                              GetListResourceResponse expected) {
        Response<GetListResourceResponse> actual = steps.sendRequest(api.getListResources());
        utilSteps.checkResponse(actual, expected);
    }

    @Test
    @DisplayName("Получение информации о конкретном ресурсе")
    void getSingleResourceTest(ResourceRetrofit api,
                               NetSteps steps,
                               @Single GetSingleResourceResponse expected) {
        Response<GetSingleResourceResponse> actual = steps.sendRequest(api.getSingleResource(2));
        utilSteps.checkResponse(actual, expected);
    }

    @Test

    @DisplayName("Получение информации о не существующем ресурсе")
    void getNotExistResourceTest(ResourceRetrofit api,
                                 NetSteps steps,
                                 @NotExist GetSingleResourceResponse expected) {
        Response<GetSingleResourceResponse> actual = steps.sendRequest(api.getSingleResource(23));
        utilSteps.checkBadResponse(actual, expected);
    }
}
