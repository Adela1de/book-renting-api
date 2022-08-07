package luiz.augusto.Bookstoreapi.model.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import luiz.augusto.Bookstoreapi.model.entities.enums.RentingStatus;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "tb_rentbook")
@NoArgsConstructor
public class RentBook implements Serializable {

    private static final int EXPIRATION_TIME = 10;

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
    private Date expirationTime;

    public RentBook(User user, RentingStatus rentingStatus)
    {
        this.user = user;
        setRentingStatus(rentingStatus);
        this.expirationTime = calculateExpirationTime(EXPIRATION_TIME);
    }

    private Date calculateExpirationTime(int expirationTime)
    {
        var calendar = Calendar.getInstance();
        calendar.setTimeInMillis(new Date().getTime());
        calendar.add(Calendar.MINUTE, expirationTime);
        return new Date(calendar.getTime().getTime());
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
