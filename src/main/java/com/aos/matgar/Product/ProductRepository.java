package com.aos.matgar.Product;

import com.aos.matgar.Brand.Brand;
import com.aos.matgar.Category.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product ,Long> {
    public Product findFirstById(Long Id);
    public void deleteById(Long id);
}
