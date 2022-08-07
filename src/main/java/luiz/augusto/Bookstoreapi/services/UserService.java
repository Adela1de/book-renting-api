package luiz.augusto.Bookstoreapi.services;

import lombok.RequiredArgsConstructor;
import luiz.augusto.Bookstoreapi.exceptions.ObjectNotFoundException;
import luiz.augusto.Bookstoreapi.model.entities.Book;
import luiz.augusto.Bookstoreapi.model.entities.RentBook;
import luiz.augusto.Bookstoreapi.model.entities.User;
import luiz.augusto.Bookstoreapi.repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public List<RentBook> getRentsByUser(Long userId)
    {
        var user = findUserByIdOrElseThrowObjectNotFoundException(userId);

        return user.getRents();
    }

    public List<Book> getLikedBooks(Long userId)
    {
        var user = findUserByIdOrElseThrowObjectNotFoundException(userId);
        return user.getBooksLiked();
    }

    public User findUserByIdOrElseThrowObjectNotFoundException(Long userId)
    {
        return userRepository.findById(userId).orElseThrow(
                () -> new ObjectNotFoundException("User not found")
        );
    }

}
