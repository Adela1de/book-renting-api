package luiz.augusto.Bookstoreapi.services;

import lombok.RequiredArgsConstructor;
import luiz.augusto.Bookstoreapi.exceptions.ObjectNotFoundException;
import luiz.augusto.Bookstoreapi.model.entities.User;
import luiz.augusto.Bookstoreapi.repositories.UserRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public User getUserById(Long userId)
    {
        return userRepository.findById(userId).orElseThrow(
                () -> new ObjectNotFoundException("There is no user with id = "+ userId));
    }

    public User createUser(User user)
    {
        return userRepository.save(user);
    }
}
