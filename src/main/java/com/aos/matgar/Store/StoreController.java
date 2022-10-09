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

    @PostMapping("saveStore")
    public ResponseEntity saveStore(@RequestBody Store store){
        return storeService.saveStore(store);
    }

    @PostMapping("deleteStore")
    public ResponseEntity deleteStore(@RequestBody Map store){
        return storeService.deleteStoreById(Long.valueOf(store.get("storeId").toString()) );
    }
}
