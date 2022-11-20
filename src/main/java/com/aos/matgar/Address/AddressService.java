package com.aos.matgar.Address;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class AddressService {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private AddressRepository addressRepository;

    public List<Address> getAllAddresses(){
        return addressRepository.findAll();
    }

    public Address getAddressById(long addressId){
        return addressRepository.findFirstById(addressId);
    }

    public List<Address> getAddressByUserId(long userId){
        return addressRepository.findAllByUserId(userId);
    }

    @Transactional
    public ResponseEntity saveAddress(Address address){
        try {
            addressRepository.save(address);
            return new ResponseEntity("Saved Successfully", HttpStatus.OK);
        }catch (Exception e){
            logger.error("Failure in Address Save",e);
            return new ResponseEntity("Failure in Address Save", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity saveAllAddress(List<Address> address){
        try {
            addressRepository.saveAll(address);
            return new ResponseEntity("Saved Successfully", HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity("Failure in Address Save", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Transactional
    public ResponseEntity deleteAddressById(long addressId){
        try {
            addressRepository.deleteById(addressId);
            return new ResponseEntity("Deleted Successfully", HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity("Failure in Address Delete", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
