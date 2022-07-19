package luiz.augusto.Bookstoreapi.model.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import luiz.augusto.Bookstoreapi.model.entities.enums.RentingStatus;

import javax.persistence.*;
import java.io.Serializable;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "tb_renting")
@NoArgsConstructor
public class Renting implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    @Setter
    private Long id;
    @Getter
    @Setter
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
    @Getter
    @Setter
    @OneToMany(mappedBy = "id.renting")
    private List<RentedBook> books = new ArrayList<>();
    private Integer rentingStatus;
    @Getter
    @Setter
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'", timezone = "GMT")
    private Instant moment;

    public Renting(Instant moment, RentingStatus rentingStatus, User user)
    {
        this.moment = moment;
        setRentingStatus(rentingStatus);
        this.user = user;
    }

    public RentingStatus getRentingStatus(){ return RentingStatus.valueOf(rentingStatus);}

    public void setRentingStatus(RentingStatus rentingStatus)
    {
        if(rentingStatus != null) this.rentingStatus = rentingStatus.getCode();
    }

}
