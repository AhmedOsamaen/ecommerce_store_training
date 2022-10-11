package com.aos.matgar.Product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@CrossOrigin("*")
public class ProductController {
    @Autowired
    ProductService productService;

    @GetMapping("/getAllProducts")
    public ResponseEntity getAllProducts(){
        return productService.getAllProducts();
    }

    @GetMapping("/getProductById/{id}")
    public ResponseEntity getProductById(@PathVariable long id){
        return productService.getProductById(id);
    }

    @GetMapping("/getProductByStoreId/{id}")
    public ResponseEntity getProductByStoreId(@PathVariable long id){
        return productService.getProductByStoreId(id);
    }

    @PostMapping("addProduct")
    public ResponseEntity addProduct(@RequestBody Map<String,Object> requestMap){
        return productService.addProduct(requestMap);
    }

    @GetMapping("deleteProductById/{id}")
    public ResponseEntity deleteProductById(@PathVariable long id){
        return productService.deleteProductById(id);
    }

}
