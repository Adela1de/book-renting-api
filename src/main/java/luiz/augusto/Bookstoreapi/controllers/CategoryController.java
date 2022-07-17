package luiz.augusto.Bookstoreapi.controllers;

import lombok.RequiredArgsConstructor;
import luiz.augusto.Bookstoreapi.model.entities.Category;
import luiz.augusto.Bookstoreapi.repositories.CategoryRepository;
import luiz.augusto.Bookstoreapi.services.CategoryService;
import org.apache.coyote.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/categories")
@CrossOrigin("*")
public class CategoryController {

    private final CategoryService categoryService;

    @GetMapping(path = "{categoryId}")
    public ResponseEntity<Category> getCategoryById(@PathVariable Long categoryId)
    {

        return ResponseEntity.ok(categoryService.getCategoryById(categoryId));
    }

    @GetMapping
    public ResponseEntity<List<Category>> getAllCategories()
    {
        return ResponseEntity.ok(categoryService.getAllCategories());
    }
}

