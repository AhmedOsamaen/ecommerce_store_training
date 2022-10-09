package com.aos.matgar.Category;
import com.aos.matgar.Brand.Brand;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category,Long> {
    public Category findFirstById(Long Id);
    public void deleteById(Long id);
}
