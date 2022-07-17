package luiz.augusto.Bookstoreapi.repositories;

import luiz.augusto.Bookstoreapi.model.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
