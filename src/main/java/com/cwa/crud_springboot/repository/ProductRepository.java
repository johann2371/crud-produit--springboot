package com.cwa.crud_springboot.repository;

import com.cwa.crud_springboot.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
