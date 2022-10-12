package com.aos.matgar.Store;

import com.aos.matgar.Product.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StoreRepository extends JpaRepository<Store,Long> {
    Store  findFirstById(long id);
    List<Store> findAllByUserId(long userId);
}
