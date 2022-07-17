package luiz.augusto.Bookstoreapi.controllers;

import lombok.RequiredArgsConstructor;
import luiz.augusto.Bookstoreapi.model.entities.Book;
import luiz.augusto.Bookstoreapi.services.BookService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/books")
@CrossOrigin("*")
public class BookController {

    private final BookService bookService;

    @GetMapping
    public ResponseEntity<Iterable<Book>> getAllBooks(){ return ResponseEntity.ok(bookService.getAllBooks()); }

    @GetMapping(path = "{bookId}")
    public ResponseEntity<Book> getBookById(@PathVariable Long bookId)
    {
        return ResponseEntity.ok(bookService.getBookById(bookId));
    }
}
