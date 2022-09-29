package com.aos.matgar.Address;

import com.aos.matgar.Order.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin("*")
public class AddressController {

    @Autowired
    private AddressService addressService;

    @GetMapping("getAllAddresses")
    public List<Address> getAllAddresses(){
        return addressService.getAllAddresses();
    }

    @GetMapping("getAddressById/{addressId}")
    public Address getAddressById(@PathVariable("addressId")String addressId){
        return addressService.getAddressById(Long.valueOf(addressId));
    }

    @PostMapping("saveAddress")
    public ResponseEntity saveAddress(@RequestBody Address address){
        return addressService.saveAddress(address);
    }

    @PostMapping("deleteAddress")
    public ResponseEntity deleteAddress(@RequestBody Map address){
        return addressService.deleteAddressById(Long.valueOf(address.get("addressId").toString()) );
    }
}
