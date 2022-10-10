package com.aos.matgar.Brand;

import org.springframework.data.jpa.repository.JpaRepository;

public interface BrandRepository extends JpaRepository<Brand,Long> {
    public Brand findFirstById(Long Id);
    public void deleteById(Long id);
}
