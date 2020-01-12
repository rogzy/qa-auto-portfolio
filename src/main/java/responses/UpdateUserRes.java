package responses;

import lombok.Getter;

import java.util.Objects;

@Getter
public class UpdateUserRes {
    String name;
    String job;
    String createdAt;

    public UpdateUserRes(String name, String job) {
        this.name = name;
        this.job = job;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UpdateUserRes that = (UpdateUserRes) o;
        return Objects.equals(name, that.name) &&
                Objects.equals(job, that.job);
    }
}
