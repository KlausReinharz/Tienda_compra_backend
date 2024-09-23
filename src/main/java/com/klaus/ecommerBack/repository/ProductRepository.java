package com.klaus.ecommerBack.repository;

import com.klaus.ecommerBack.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

//se instancia la entidad producto
@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    List<Product> findAllByNameContaining(String title);
}
