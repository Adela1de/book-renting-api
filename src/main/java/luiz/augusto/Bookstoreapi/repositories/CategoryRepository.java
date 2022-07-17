package luiz.augusto.Bookstoreapi.repositories;

import luiz.augusto.Bookstoreapi.model.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
}
