package com.cwa.crud_springboot.service;

import com.cwa.crud_springboot.entity.Product;
import java.util.List;

public interface ProductService {

    List<Product> findAll();
    Product findById(Long id);
    Product save(Product product);
    Product update(Long id, Product product);
    void delete(Long id);
}
