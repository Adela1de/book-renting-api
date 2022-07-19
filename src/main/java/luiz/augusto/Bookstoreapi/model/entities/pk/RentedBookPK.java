package luiz.augusto.Bookstoreapi.model.entities.pk;

import lombok.Getter;
import lombok.Setter;
import luiz.augusto.Bookstoreapi.model.entities.Book;
import luiz.augusto.Bookstoreapi.model.entities.Renting;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Embeddable
@Getter
@Setter
public class RentedBookPK {

    @ManyToOne
    @JoinColumn(name = "renting_id")
    private Renting renting;
    @ManyToOne
    @JoinColumn(name = "book_id")
    private Book book;

}
