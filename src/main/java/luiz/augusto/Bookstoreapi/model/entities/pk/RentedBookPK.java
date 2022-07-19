package luiz.augusto.Bookstoreapi.model.entities.pk;

import lombok.Getter;
import lombok.Setter;
import luiz.augusto.Bookstoreapi.model.entities.Book;
import luiz.augusto.Bookstoreapi.model.entities.Renting;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.io.Serializable;

@Embeddable
@Getter
@Setter
public class RentedBookPK implements Serializable {

    @ManyToOne
    @JoinColumn(name = "renting_id")
    private Renting renting;
    @ManyToOne
    @JoinColumn(name = "book_id")
    private Book book;

}
