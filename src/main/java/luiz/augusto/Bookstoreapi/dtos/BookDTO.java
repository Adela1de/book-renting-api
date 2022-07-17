package luiz.augusto.Bookstoreapi.dtos;

import lombok.Getter;
import lombok.Setter;
import luiz.augusto.Bookstoreapi.model.entities.Category;

import java.util.List;

@Getter
@Setter
public class BookDTO {
    private String title;
    private String author;
    private String publication;
    private List<Category> categories;
}
