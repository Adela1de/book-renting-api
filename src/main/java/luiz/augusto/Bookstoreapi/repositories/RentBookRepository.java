package luiz.augusto.Bookstoreapi.repositories;

import luiz.augusto.Bookstoreapi.model.entities.RentBook;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RentBookRepository extends JpaRepository<RentBook, Long> {
}
