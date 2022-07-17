package luiz.augusto.Bookstoreapi.services;

import lombok.RequiredArgsConstructor;
import luiz.augusto.Bookstoreapi.model.entities.Book;
import luiz.augusto.Bookstoreapi.repositories.BookRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BookService {

    private final BookRepository bookRepository;

    public List<Book> getAllBooks() { return bookRepository.findAll(); }

    public Book getBookById(Long bookId) { return bookRepository.findById(bookId).get(); }
}
