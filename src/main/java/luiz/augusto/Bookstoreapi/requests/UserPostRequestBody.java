package luiz.augusto.Bookstoreapi.requests;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserPostRequestBody {

    private String username;
    private String password;
    private String email;

}
