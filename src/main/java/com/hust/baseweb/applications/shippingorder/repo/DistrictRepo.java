package com.hust.baseweb.applications.shippingorder.repo;

import com.hust.baseweb.applications.shippingorder.entity.District;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DistrictRepo extends JpaRepository<District, String> {
    List<District> findByProvinceId(String provinceId);
    District getById(String id);
}
