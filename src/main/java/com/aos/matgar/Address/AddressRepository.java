package com.aos.matgar.Address;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AddressRepository extends JpaRepository<Address,Long> {
    Address findFirstById(long id);
    List<Address> findAllByUserId(long id);
}
