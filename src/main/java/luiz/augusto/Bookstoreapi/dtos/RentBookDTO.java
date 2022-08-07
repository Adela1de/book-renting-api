package luiz.augusto.Bookstoreapi.dtos;

import lombok.Getter;
import lombok.Setter;
import luiz.augusto.Bookstoreapi.model.entities.enums.RentingStatus;

import java.util.Date;
import java.util.List;

@Getter
@Setter
public class RentBookDTO {

    private UserDTO user;
    private List<BookDTO> rentedBooks;
    private RentingStatus rentingStatus;
    private Date expirationTime;

}
