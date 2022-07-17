package luiz.augusto.Bookstoreapi.repositories;

import luiz.augusto.Bookstoreapi.model.entities.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
}
