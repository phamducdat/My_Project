package com.hust.baseweb.applications.logistics.repo;

import com.hust.baseweb.applications.logistics.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface ProductRepo extends JpaRepository<Product, String> {
    Product findByProductId(String productId);

    List<Product> findAllByProductIdIn(List<String> productIds);
}
