package luiz.augusto.Bookstoreapi.services;

import lombok.RequiredArgsConstructor;
import luiz.augusto.Bookstoreapi.exceptions.ObjectNotFoundException;
import luiz.augusto.Bookstoreapi.model.entities.Book;
import luiz.augusto.Bookstoreapi.repositories.BookRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BookService {

    private final BookRepository bookRepository;

    public List<Book> getAllBooks() { return bookRepository.findAll(); }

    public Book getBookById(Long bookId) {
        return bookRepository.findById(bookId).orElseThrow(
                () -> new ObjectNotFoundException("There is no book with id = " +bookId));
    }
}
