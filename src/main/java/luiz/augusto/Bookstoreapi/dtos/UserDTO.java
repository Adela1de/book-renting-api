package luiz.augusto.Bookstoreapi.dtos;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class UserDTO {

    private String username;
    private String password;
    private String email;
    private List<BookDTO> booksLiked;

}
