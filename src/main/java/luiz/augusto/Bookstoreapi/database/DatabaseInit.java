package luiz.augusto.Bookstoreapi.database;

import lombok.RequiredArgsConstructor;
import luiz.augusto.Bookstoreapi.model.entities.Book;
import luiz.augusto.Bookstoreapi.model.entities.Category;
import luiz.augusto.Bookstoreapi.model.entities.User;
import luiz.augusto.Bookstoreapi.repositories.BookRepository;
import luiz.augusto.Bookstoreapi.repositories.CategoryRepository;
import luiz.augusto.Bookstoreapi.repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
@RequiredArgsConstructor
public class DatabaseInit {

    private final UserRepository userRepository;
    private final BookRepository bookRepository;
    private final CategoryRepository categoryRepository;

    public void createObjectsForTesting()
    {
        User u1 = new User("Adelaide", "3104", "luizadelaide@gmail.com");
        User u2 = new User("Nathalia", "3104", "nathaliaadelaide@gmail.com");
        User u3 = new User("Joao", "6666", "joaojoao@gmail.com");

        Book b1 = new Book("1984", "George Orwell", "Secker & Warburg");
        Book b2 = new Book("The little prince", "Antoine de Saint-Exupéry", "Reynal & Hitchcock");
        Book b3 = new Book("american psycho", "Bret Easton Ellis", "Vintage");

        Category cat1 = new Category("dystopia ","Books where the events takes place in a dystopian universe");
        Category cat2 = new Category("Children's literature", "Books for kids");
        Category cat3 = new Category("thriller", "books about thriller");

        userRepository.saveAll(Arrays.asList(u1, u2, u3));
        bookRepository.saveAll(Arrays.asList(b1, b2, b3));
        categoryRepository.saveAll(Arrays.asList(cat1, cat2, cat3));

        b1.getCategories().add(cat1);
        b2.getCategories().add(cat2);
        b3.getCategories().add(cat3);

        bookRepository.saveAll(Arrays.asList(b1, b2, b3));

        u1.getBooksLiked().addAll(Arrays.asList(b2, b3));
        u2.getBooksLiked().addAll(Arrays.asList(b1, b2));
        u3.getBooksLiked().add(b3);

        userRepository.saveAll(Arrays.asList(u1, u2, u3));

    }
}
