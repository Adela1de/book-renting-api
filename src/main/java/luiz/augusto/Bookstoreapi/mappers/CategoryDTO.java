package luiz.augusto.Bookstoreapi.mappers;

import lombok.RequiredArgsConstructor;
import luiz.augusto.Bookstoreapi.model.entities.Category;
import org.modelmapper.ModelMapper;

@RequiredArgsConstructor
public class CategoryDTO {

    public static final ModelMapper mapper = new ModelMapper();

    public static CategoryDTO toCategoryDTO(Category category)
    {
        CategoryDTO categoryDTO = mapper.map(category, CategoryDTO.class);
        return categoryDTO;
    }
}
