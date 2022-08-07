package luiz.augusto.Bookstoreapi.controllers;

import lombok.RequiredArgsConstructor;
import luiz.augusto.Bookstoreapi.dtos.BookDTO;
import luiz.augusto.Bookstoreapi.dtos.RentBookDTO;
import luiz.augusto.Bookstoreapi.mappers.BookMapper;
import luiz.augusto.Bookstoreapi.mappers.RentBookMapper;
import luiz.augusto.Bookstoreapi.mappers.UserMapper;
import luiz.augusto.Bookstoreapi.model.entities.Book;
import luiz.augusto.Bookstoreapi.model.entities.RentBook;
import luiz.augusto.Bookstoreapi.services.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/users")
@CrossOrigin("*")
public class UserController {

    private final UserService userService;

    @GetMapping("/liked/{userId}")
    public ResponseEntity<Iterable<BookDTO>> getLikedBooks(@RequestParam Long userId)
    {
        return ResponseEntity.ok(
                userService.
                getLikedBooks(userId).
                stream().
                map(BookMapper::toBookDTO).
                collect(Collectors.toList())
        );
    }

    @GetMapping("/rents/{userId}")
    public ResponseEntity<Iterable<RentBookDTO>> getUserRents(@RequestParam Long userId)
    {
        return ResponseEntity.ok(
                userService.
                getRentsByUser(userId).
                stream().
                map(RentBookMapper::toRentBookDTO).
                collect(Collectors.toList())
        );
    }

}
