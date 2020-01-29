package ru.rogzy.api.aut.models.user.get_list;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import ru.rogzy.api.aut.models.user.get_obj.UserData;

import java.util.List;

@Getter
@EqualsAndHashCode
public class GetListUsersResponse {
    Integer page;
    Integer perPage;
    Integer total;
    Integer totalPages;
    @EqualsAndHashCode.Exclude
    List<UserData> data;

    public GetListUsersResponse() {
        this.page = 2;
        this.total = 12;
    }
}
