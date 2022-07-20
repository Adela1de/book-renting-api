package luiz.augusto.Bookstoreapi.mappers;

import lombok.RequiredArgsConstructor;
import luiz.augusto.Bookstoreapi.dtos.BookDTO;
import luiz.augusto.Bookstoreapi.dtos.RentBookDTO;
import luiz.augusto.Bookstoreapi.model.entities.Book;
import luiz.augusto.Bookstoreapi.model.entities.RentBook;
import org.modelmapper.ModelMapper;

@RequiredArgsConstructor
public class RentBookMapper {

    private static final ModelMapper mapper = new ModelMapper();

    public static RentBookDTO toRentBookDTO(RentBook rentBook)
    {
        var rentBookDTO = mapper.map(rentBook, RentBookDTO.class);
        return rentBookDTO;
    }

}
