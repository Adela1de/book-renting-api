package luiz.augusto.Bookstoreapi.model.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import luiz.augusto.Bookstoreapi.model.entities.pk.RentedBookPK;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@NoArgsConstructor
@Getter
@Setter
@Table(name = "tb_rent_book")
public class RentedBook implements Serializable {

    @EmbeddedId
    private RentedBookPK id;
    private Double price;

    public RentedBook(Renting renting, Book book, Double price)
    {
        id.setRenting(renting);
        id.setBook(book);
        this.price = price;
    }

    public Renting getRenting()
    {
        return id.getRenting();
    }

    public void setRenting(Renting renting)
    {
        id.setRenting(renting);
    }

    public Book getBook()
    {
        return id.getBook();
    }

    public void setBook(Book book)
    {
        id.setBook(book);
    }
}
