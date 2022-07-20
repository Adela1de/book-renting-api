package luiz.augusto.Bookstoreapi.model.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import luiz.augusto.Bookstoreapi.model.entities.enums.RentingStatus;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "tb_rentbook")
@NoArgsConstructor
public class RentBook implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Getter
    @Setter
    private Long id;
    @ManyToOne
    @JoinColumn(name = "user_id")
    @Getter
    @Setter
    private User user;
    @ManyToMany
    @JoinTable(
            name = "book_rented",
            joinColumns = @JoinColumn(name = "rent_id"),
            inverseJoinColumns = @JoinColumn(name = "book_id")
    )
    @Getter
    @Setter
    private List<Book> rentedBooks = new ArrayList<>();
    private Integer rentingStatus;

    public RentBook(User user, RentingStatus rentingStatus)
    {
        this.user = user;
        setRentingStatus(rentingStatus);
    }

    public void setRentingStatus(RentingStatus rentingStatus)
    {
        this.rentingStatus = rentingStatus.getCode();
    }

    public RentingStatus getRentingStatus()
    {
        return RentingStatus.valueOf(rentingStatus);
    }

}
