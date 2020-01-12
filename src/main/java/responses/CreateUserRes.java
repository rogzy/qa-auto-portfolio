package responses;

import lombok.Getter;

import java.util.Objects;

@Getter
public class CreateUserRes {
    String name;
    String job;
    String id;
    String createdAt;

    public CreateUserRes(String name, String job) {
        this.name = name;
        this.job = job;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CreateUserRes that = (CreateUserRes) o;
        return Objects.equals(name, that.name) &&
                Objects.equals(job, that.job);
    }
}
