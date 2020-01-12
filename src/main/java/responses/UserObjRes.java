package responses;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Objects;

@Getter
@AllArgsConstructor
public class UserObjRes {
    UserRes data;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserObjRes that = (UserObjRes) o;
        return Objects.equals(data, that.data);
    }
}
