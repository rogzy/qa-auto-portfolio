package ru.rogzy.api.aut.reqres.resource.get_obj;

import lombok.AccessLevel;
import lombok.EqualsAndHashCode;
import lombok.experimental.FieldDefaults;
import ru.rogzy.api.aut.reqres.StateEnum;
import ru.rogzy.api.core.expceptions.CoreException;

@EqualsAndHashCode
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class GetSingleResourceResponse {
    ResourceData data;

    public GetSingleResourceResponse(StateEnum stateEnum) {
        switch (stateEnum) {
            case single:
                this.data = new ResourceData();
                break;
            case notExist:
                this.data = null;
                break;
            default:
                throw new CoreException("Не целевое использование");
        }
    }
}
