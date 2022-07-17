package luiz.augusto.Bookstoreapi.mappers;

import lombok.RequiredArgsConstructor;
import luiz.augusto.Bookstoreapi.dtos.UserDTO;
import luiz.augusto.Bookstoreapi.model.entities.User;
import luiz.augusto.Bookstoreapi.requests.UserPostRequestBody;
import org.modelmapper.ModelMapper;

@RequiredArgsConstructor
public class UserMapper {

    private static final ModelMapper mapper = new ModelMapper();

    public static UserDTO toUserDTO(User user)
    {
        UserDTO userDTO = mapper.map(user, UserDTO.class);
        return userDTO;
    }

    public static User toUser(UserPostRequestBody userPostRequestBody)
    {
        User user = mapper.map(userPostRequestBody, User.class);
        return user;

    }
}
