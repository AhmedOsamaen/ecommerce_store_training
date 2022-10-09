package com.aos.matgar.Brand;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Set;

@Service
public class BrandService {

    @Autowired
    BrandRepository brandRepository;

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    ObjectMapper mapper = new ObjectMapper();

    public ResponseEntity getAllBrands(){
        try {
            logger.info("Getting All Brands");
            return new ResponseEntity(brandRepository.findAll(), HttpStatus.OK);
        }catch (Exception e) {
            logger.info("Failure in getting all Brands");
            return new ResponseEntity("Error While getting Brands Data with exception:" + e, HttpStatus.EXPECTATION_FAILED);
        }
    }

    public ResponseEntity getBrandById(long id){
        try {
            logger.info("Getting All Brands for ID: "+id);
            return new ResponseEntity(brandRepository.findFirstById(id), HttpStatus.OK);
        }catch (Exception e) {
            logger.info("Failure in getting all Brands Info for ID: "+id);
            return new ResponseEntity("Error While getting Brands Id:"+id+" with exception" + e, HttpStatus.EXPECTATION_FAILED);
        }
    }

    public ResponseEntity addBrand(Map<String,Object> requestMap){
        try {
            Brand brand = mapper.convertValue(requestMap,Brand.class);
            logger.info("Getting All Brands for ID: "+brand.id);
            return new ResponseEntity(brandRepository.save(brand), HttpStatus.OK);
        }catch (Exception e) {
            logger.info("Failure in Creating/Updating Brand ");
            return new ResponseEntity("Error While Creating/Updating with exception" + e, HttpStatus.EXPECTATION_FAILED);
        }
    }

    public ResponseEntity deleteBrandById(long id){
        try {
            logger.info("Delete Brand for ID: "+id);
            brandRepository.deleteById(id);
            return new ResponseEntity("Brand with ID:"+id+" is Deleted successfully" ,HttpStatus.OK);
        }catch (Exception e) {
            logger.info("Failure in Deleting Brand Info for ID: "+id);
            return new ResponseEntity("Error While Deleting Brand Id:"+id+" with exception" + e, HttpStatus.EXPECTATION_FAILED);
        }
    }
}
