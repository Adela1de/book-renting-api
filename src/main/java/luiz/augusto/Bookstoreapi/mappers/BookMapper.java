package luiz.augusto.Bookstoreapi.mappers;

import lombok.RequiredArgsConstructor;
import luiz.augusto.Bookstoreapi.dtos.BookDTO;
import luiz.augusto.Bookstoreapi.model.entities.Book;
import org.modelmapper.ModelMapper;

@RequiredArgsConstructor
public class BookMapper {

    private static final ModelMapper mapper = new ModelMapper();

    public static BookDTO toBookDTO(Book book)
    {
        BookDTO bookDTO = mapper.map(book, BookDTO.class);
        return bookDTO;
    }

}
