package luiz.augusto.Bookstoreapi.controllers;

import lombok.RequiredArgsConstructor;
import luiz.augusto.Bookstoreapi.dtos.BookDTO;
import luiz.augusto.Bookstoreapi.mappers.BookMapper;
import luiz.augusto.Bookstoreapi.services.BookService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/books")
@CrossOrigin("*")
public class BookController {

    private final BookService bookService;

    @GetMapping
    public ResponseEntity<Iterable<BookDTO>> getAllBooks()
    {
        var books = bookService.getAllBooks();
        var booksDTO = books.stream().map(BookMapper::toBookDTO).collect(Collectors.toList());
        return ResponseEntity.ok(booksDTO);
    }

    @GetMapping(path = "{bookId}")
    public ResponseEntity<BookDTO> getBookById(@PathVariable Long bookId)
    {
        var book = bookService.getBookById(bookId);
        var bookDTO = BookMapper.toBookDTO(book);
        return ResponseEntity.ok(bookDTO);
    }
}
