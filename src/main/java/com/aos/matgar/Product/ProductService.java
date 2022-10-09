package com.aos.matgar.Product;

import com.aos.matgar.Product.Product;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class ProductService {
    @Autowired
    ProductRepository productRepository;

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    ObjectMapper mapper = new ObjectMapper();

    public ResponseEntity getAllProducts(){
        try {
            logger.info("Getting All Products");
            return new ResponseEntity(productRepository.findAll(), HttpStatus.OK);
        }catch (Exception e) {
            logger.info("Failure in getting all Products");
            return new ResponseEntity("Error While getting Products Data with exception:" + e, HttpStatus.EXPECTATION_FAILED);
        }
    }

    public ResponseEntity getProductById(long id){
        try {
            logger.info("Getting All Products for ID: "+id);
            return new ResponseEntity(productRepository.findFirstById(id), HttpStatus.OK);
        }catch (Exception e) {
            logger.info("Failure in getting all Products Info for ID: "+id);
            return new ResponseEntity("Error While getting Products Id:"+id+" with exception" + e, HttpStatus.EXPECTATION_FAILED);
        }
    }

    public ResponseEntity addProduct(Map<String,Object> requestMap){
        try {
            Product product = mapper.convertValue(requestMap,Product.class);
            logger.info("Getting All Products for ID: "+product.id);
            return new ResponseEntity(productRepository.save(product), HttpStatus.OK);
        }catch (Exception e) {
            logger.info("Failure in Creating/Updating Product ");
            return new ResponseEntity("Error While Creating/Updating with exception" + e, HttpStatus.EXPECTATION_FAILED);
        }
    }

    public ResponseEntity deleteProductById(long id){
        try {
            logger.info("Delete Product for ID: "+id);
            productRepository.deleteById(id);
            return new ResponseEntity("Product with ID:"+id+" is Deleted successfully" ,HttpStatus.OK);
        }catch (Exception e) {
            logger.info("Failure in Deleting Product Info for ID: "+id);
            return new ResponseEntity("Error While Deleting Product Id:"+id+" with exception" + e, HttpStatus.EXPECTATION_FAILED);
        }
    }
}
