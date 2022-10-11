package com.aos.matgar.Store;

import com.aos.matgar.Order.Order;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class StoreService {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private StoreRepository storeRepository;

    public List<Store> getAllStores(){
        return storeRepository.findAll();
    }

    public Store getStoreById(long storeId){
        return storeRepository.findFirstById(storeId);
    }

    public ResponseEntity saveStore(Store store){
        try {
            storeRepository.save(store);
            return new ResponseEntity("Saved Successfully", HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity("Failure in Store Save", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity saveAllStores(List<Store> stores){
        try {
            storeRepository.saveAll(stores);
            return new ResponseEntity("Saved Successfully", HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity("Failure in Store Save", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity getStoresByUserId(long id){
        try {
            logger.info("Getting All Stores for ID: "+id);
            return new ResponseEntity(storeRepository.findAllByUserId(id), HttpStatus.OK);
        }catch (Exception e) {
            logger.info("Failure in getting all Stores Info for ID: "+id);
            return new ResponseEntity("Error While getting Stores Id:"+id+" with exception" + e, HttpStatus.EXPECTATION_FAILED);
        }
    }

    @Transactional
    public ResponseEntity deleteStoreById(long storeId){
        try {
            storeRepository.deleteById(storeId);
            return new ResponseEntity("Deleted Successfully", HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity("Failure in Store Delete", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
