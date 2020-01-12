package requestes;

import lombok.Getter;

@Getter
public class CreateUserReq {
    String name;
    String job;

    public CreateUserReq(String name, String job) {
        this.name = name;
        this.job = job;
    }

    public CreateUserReq() {
        this.name = "Bob";
        this.job = "Unemployed";
    }
}
