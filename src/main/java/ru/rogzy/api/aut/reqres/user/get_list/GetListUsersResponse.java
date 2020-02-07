package ru.rogzy.api.aut.reqres.user.get_list;

import lombok.AccessLevel;
import lombok.EqualsAndHashCode;
import lombok.experimental.FieldDefaults;
import ru.rogzy.api.aut.reqres.StateEnum;
import ru.rogzy.api.aut.reqres.user.get_obj.UserData;
import ru.rogzy.api.core.expceptions.CoreException;

import java.util.List;

@EqualsAndHashCode
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class GetListUsersResponse {
    Integer page;
    Integer per_page;
    Integer total;
    Integer total_pages;
    @EqualsAndHashCode.Exclude
    List<UserData> data;

    public GetListUsersResponse(StateEnum stateEnum) {
        this.total = 12;
        this.per_page = 6;
        this.total_pages = 2;
        this.data = null;
        switch (stateEnum) {
            case simple:
                this.page = 2;
                break;
            case delay:
                this.page = 1;
                break;
            default:
                throw new CoreException("Не целевое использование");
        }
    }
}
