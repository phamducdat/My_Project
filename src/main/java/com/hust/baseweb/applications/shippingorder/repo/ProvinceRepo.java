package com.hust.baseweb.applications.shippingorder.repo;


import org.springframework.data.jpa.repository.JpaRepository;

import com.hust.baseweb.applications.shippingorder.entity.Province;


public interface ProvinceRepo extends JpaRepository<com.hust.baseweb.applications.shippingorder.entity.Province, String> {
    Province getById(String id);
}
