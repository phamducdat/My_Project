package com.hust.baseweb.applications.shippingorder.service;

import com.hust.baseweb.applications.shippingorder.entity.Commune;
import com.hust.baseweb.applications.shippingorder.entity.District;
import com.hust.baseweb.applications.shippingorder.entity.Province;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface AddressService {
    List<Province> getProvinces();
    List<District> getRespectiveDistricts(String provinceId);
    List<Commune> getRespectiveCommunes(String districtId);
    String getFullAddress(String communeId);
}
