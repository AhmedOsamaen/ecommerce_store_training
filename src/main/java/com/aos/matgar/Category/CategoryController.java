package com.aos.matgar.Category;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@CrossOrigin("*")
public class CategoryController {
    @Autowired
    CategoryService categoryService;

    @GetMapping("/getAllCategories")
    public ResponseEntity getAllCategorys(){
        return categoryService.getAllCategories();
    }

    @GetMapping("/getCategoryById/{id}")
    public ResponseEntity getCategoryById(@PathVariable long id){
        return categoryService.getCategoryById(id);
    }

    @PostMapping("/addCategory")
    public ResponseEntity addCategory(@RequestBody Map<String,Object> requestMap){
        return categoryService.addCategory(requestMap);
    }

    @GetMapping("deleteCategoryById/{id}")
    public ResponseEntity deleteCategoryById(@PathVariable long id){
        return categoryService.deleteCategoryById(id);
    }
}
