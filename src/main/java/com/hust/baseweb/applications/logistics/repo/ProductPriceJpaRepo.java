package com.hust.baseweb.applications.logistics.repo;

import com.hust.baseweb.applications.logistics.entity.Product;
import com.hust.baseweb.applications.logistics.entity.ProductPrice;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;
import java.util.UUID;

public interface ProductPriceJpaRepo extends JpaRepository<ProductPrice, UUID> {
    List<ProductPrice> findByProductAndThruDate(Product product, Date thruDate);
}
