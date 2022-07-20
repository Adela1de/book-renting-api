package luiz.augusto.Bookstoreapi.controllers;

import lombok.RequiredArgsConstructor;
import luiz.augusto.Bookstoreapi.dtos.RentBookDTO;
import luiz.augusto.Bookstoreapi.mappers.RentBookMapper;
import luiz.augusto.Bookstoreapi.model.entities.RentBook;
import luiz.augusto.Bookstoreapi.services.RentBookService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequiredArgsConstructor
@RequestMapping(value = "/rentbooks")
@CrossOrigin("*")
public class RentBookController {

    private final RentBookService rentBookService;

    @GetMapping
    public ResponseEntity<List<RentBookDTO>> getAllRents()
    {
        var rentBooks = rentBookService.getAllRents();
        var rentBooksDTO = rentBooks.stream().map(RentBookMapper::toRentBookDTO).collect(Collectors.toList());
        return ResponseEntity.ok(rentBooksDTO);
    }

    @GetMapping(path = "{rentBookId}")
    public ResponseEntity<RentBookDTO> getRentBookById(@PathVariable Long rentBookId)
    {
        var rentBook = rentBookService.getRentById(rentBookId);
        var rentBookDTO = RentBookMapper.toRentBookDTO(rentBook);
        return ResponseEntity.ok(rentBookDTO);
    }
}
