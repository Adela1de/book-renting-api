package luiz.augusto.Bookstoreapi.dtos;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class BookDTO {
    private String title;
    private String author;
    private String publication;
    private List<CategoryDTO> categories;
}
