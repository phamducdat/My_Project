package com.hust.baseweb.applications.shippingorder.repo;

import com.hust.baseweb.applications.shippingorder.entity.Commune;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommuneRepo extends JpaRepository<Commune, String> {
    List<Commune> findByDistrictId(String districtId);
    Commune getById(String id);
}