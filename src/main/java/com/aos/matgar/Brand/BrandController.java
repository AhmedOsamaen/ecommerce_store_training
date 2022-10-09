package com.aos.matgar.Brand;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@CrossOrigin("*")
public class BrandController {
    @Autowired
    BrandService brandService;

    @GetMapping("/getAllBrands")
    public ResponseEntity getAllBrands(){
        return brandService.getAllBrands();
    }

    @GetMapping("/getBrandById/{id}")
    public ResponseEntity getBrandById(@PathVariable long id){
        return brandService.getBrandById(id);
    }

    @PostMapping("addBrand")
    public ResponseEntity addBrand(@RequestBody Map<String,Object> requestMap){
        return brandService.addBrand(requestMap);
    }

    @GetMapping("deleteBrandById/{id}")
    public ResponseEntity deleteBrandById(@PathVariable long id){
        return brandService.deleteBrandById(id);
    }

}
