package com.aos.matgar.Product;

import com.aos.matgar.Brand.Brand;
import com.aos.matgar.Category.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product ,Long> {
    public Product findFirstById(Long Id);
    public void deleteById(Long id);
    List<Product> findAllByStoreId(long storeId);
}
