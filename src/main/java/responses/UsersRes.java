package responses;

import lombok.Getter;

import java.util.List;

@Getter
public class UsersRes {
    Integer page;
    Integer perPage;
    Integer total;
    Integer totalPages;
    List<UserRes> data;
}
