package com.aos.matgar.Store;

import org.springframework.data.jpa.repository.JpaRepository;

public interface StoreRepository extends JpaRepository<Store,Long> {
    Store  findFirstById(long id);
}