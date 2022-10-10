package com.aos.matgar.Category;

import com.aos.matgar.Category.Category;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Map;

@Service
@Transactional
public class CategoryService {
    @Autowired
    CategoryRepository categoryRepository;

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    ObjectMapper mapper = new ObjectMapper();

    public ResponseEntity getAllCategories(){
        try {
            logger.info("Getting All Categories");
            return new ResponseEntity(categoryRepository.findAll(), HttpStatus.OK);
        }catch (Exception e) {
            logger.info("Failure in getting all Categories");
            return new ResponseEntity("Error While getting Categories Data with exception:" + e, HttpStatus.EXPECTATION_FAILED);
        }
    }

    public ResponseEntity getCategoryById(long id){
        try {
            logger.info("Getting All Categories for ID: "+id);
            return new ResponseEntity(categoryRepository.findFirstById(id), HttpStatus.OK);
        }catch (Exception e) {
            logger.info("Failure in getting all Categories Info for ID: "+id);
            return new ResponseEntity("Error While getting Categories Id:"+id+" with exception" + e, HttpStatus.EXPECTATION_FAILED);
        }
    }

    public ResponseEntity addCategory(Map<String,Object> requestMap){
        try {
            Category category = mapper.convertValue(requestMap,Category.class);
            logger.info("Getting All Categories for ID: "+category.id);
            return new ResponseEntity(category, HttpStatus.OK);
        }catch (Exception e) {
            logger.info("Failure in Creating/Updating Category ");
            return new ResponseEntity("Error While Creating/Updating with exception" + e, HttpStatus.EXPECTATION_FAILED);
        }
    }

    public ResponseEntity deleteCategoryById(long id){
        try {
            logger.info("Delete Category for ID: "+id);
            categoryRepository.deleteById(id);
            return new ResponseEntity("Category with ID:"+id+" is Deleted successfully" ,HttpStatus.OK);
        }catch (Exception e) {
            logger.info("Failure in Deleting Category Info for ID: "+id);
            return new ResponseEntity("Error While Deleting Category Id:"+id+" with exception" + e, HttpStatus.EXPECTATION_FAILED);
        }
    }
}
