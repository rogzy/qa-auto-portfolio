package requestes;

import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;

@FieldDefaults(level = AccessLevel.PRIVATE)
public class UpdateUserReq {
    String name;
    String job;

    public UpdateUserReq() {
        this.name = "John";
        this.job = "Doctor";
    }

    public UpdateUserReq(String name, String job) {
        this.name = name;
        this.job = job;
    }
}
