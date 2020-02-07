package ru.rogzy.api.aut.reqres.resource.get_list;

import lombok.AccessLevel;
import lombok.EqualsAndHashCode;
import lombok.experimental.FieldDefaults;
import ru.rogzy.api.aut.reqres.resource.get_obj.ResourceData;

import java.util.List;

@EqualsAndHashCode
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class GetListResourceResponse {
    Integer page;
    Integer per_page;
    Integer total;
    Integer total_pages;
    @EqualsAndHashCode.Exclude
    List<ResourceData> data;


    public GetListResourceResponse() {
        this.page = 1;
        this.per_page = 6;
        this.total = 12;
        this.total_pages = 2;
        this.data = null;
    }
}
