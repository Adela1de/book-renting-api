package luiz.augusto.Bookstoreapi.services;

import lombok.RequiredArgsConstructor;
import luiz.augusto.Bookstoreapi.exceptions.ObjectNotFoundException;
import luiz.augusto.Bookstoreapi.model.entities.Category;
import luiz.augusto.Bookstoreapi.repositories.CategoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryService {

    private final CategoryRepository categoryRepository;

    public List<Category> getAllCategories(){ return categoryRepository.findAll(); }

    public Category getCategoryById(Long categoryId){
        return categoryRepository.findById(categoryId).orElseThrow(
                () -> new ObjectNotFoundException("There is no category with id = "+ categoryId));
    }
}
