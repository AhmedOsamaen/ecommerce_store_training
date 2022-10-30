package com.aos.matgar.Store;

import com.aos.matgar.Store.Store;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin("*")
public class StoreController {

    @Autowired
    private StoreService storeService;

    @GetMapping("getAllStores")
    public List<Store> getAllStores(){
        return storeService.getAllStores();
    }

    @GetMapping("getStoreById/{storeId}")
    public Store getStoreById(@PathVariable("storeId")String storeId){
        return storeService.getStoreById(Long.valueOf(storeId));
    }

    @GetMapping("/getStoreByUserId/{id}")
    public ResponseEntity getStoreByUserId(@PathVariable long id){
        return storeService.getStoresByUserId(id);
    }

    @PostMapping("saveStore")
    public ResponseEntity saveStore(@RequestBody Store store){
        return storeService.saveStore(store);
    }

    @GetMapping("deleteStoreById/{id}")
    public ResponseEntity deleteStore(@PathVariable("id")long storeId){
        return storeService.deleteStoreById(storeId);
    }
}
