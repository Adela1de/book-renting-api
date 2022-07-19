package luiz.augusto.Bookstoreapi.controllers;

import lombok.RequiredArgsConstructor;
import luiz.augusto.Bookstoreapi.dtos.CategoryDTO;
import luiz.augusto.Bookstoreapi.mappers.CategoryMapper;
import luiz.augusto.Bookstoreapi.services.CategoryService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/categories")
@CrossOrigin("*")
public class CategoryController {

    private final CategoryService categoryService;

    @GetMapping(path = "{categoryId}")
    public ResponseEntity<CategoryDTO> getCategoryById(@PathVariable Long categoryId)
    {
        var category = categoryService.getCategoryById(categoryId);
        var categoryDTO = CategoryMapper.toCategoryDTO(category);
        return ResponseEntity.ok(categoryDTO);
    }

    @GetMapping
    public ResponseEntity<List<CategoryDTO>> getAllCategories()
    {
        var categories = categoryService.getAllCategories();
        var categoriesDTO =
                categories.
                stream().
                map(CategoryMapper::toCategoryDTO).
                collect(Collectors.toList());
        return ResponseEntity.ok(categoriesDTO);
    }
}

