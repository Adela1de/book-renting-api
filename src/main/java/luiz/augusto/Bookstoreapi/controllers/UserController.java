package luiz.augusto.Bookstoreapi.controllers;

import lombok.RequiredArgsConstructor;
import luiz.augusto.Bookstoreapi.dtos.UserDTO;
import luiz.augusto.Bookstoreapi.mappers.UserMapper;
import luiz.augusto.Bookstoreapi.model.entities.User;
import luiz.augusto.Bookstoreapi.requests.UserPostRequestBody;
import luiz.augusto.Bookstoreapi.services.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/users")
@CrossOrigin("*")
public class UserController {

    private final UserService userService;

    @GetMapping(path = "{userId}")
    public ResponseEntity<UserDTO> findById(@PathVariable Long userId)
    {
        User user = userService.getUserById(userId);
        UserDTO userDTO = UserMapper.toUserDTO(user);
        return ResponseEntity.ok(userDTO);
    }

    @PostMapping(path = "/register")
    public ResponseEntity<Void> registerUser(@RequestBody UserPostRequestBody userPostRequestBody)
    {
        User user = UserMapper.toUser(userPostRequestBody);
        userService.createUser(user);
        return ResponseEntity.noContent().build();
    }

}
