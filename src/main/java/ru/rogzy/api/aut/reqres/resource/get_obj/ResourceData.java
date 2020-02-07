package ru.rogzy.api.aut.reqres.resource.get_obj;

import lombok.AccessLevel;
import lombok.EqualsAndHashCode;
import lombok.experimental.FieldDefaults;

@EqualsAndHashCode
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class ResourceData {
    int id;
    String name;
    int year;
    String color;
    String pantone_value;


    public ResourceData() {
        this.id = 2;
        name = "fuchsia rose";
        year = 2001;
        color = "#C74375";
        pantone_value = "17-2031";
    }
}
