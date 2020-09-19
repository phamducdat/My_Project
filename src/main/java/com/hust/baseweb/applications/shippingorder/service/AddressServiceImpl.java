package com.hust.baseweb.applications.shippingorder.service;

import com.hust.baseweb.applications.shippingorder.entity.Commune;
import com.hust.baseweb.applications.shippingorder.entity.District;
import com.hust.baseweb.applications.shippingorder.entity.Province;
import com.hust.baseweb.applications.shippingorder.repo.CommuneRepo;
import com.hust.baseweb.applications.shippingorder.repo.DistrictRepo;
import com.hust.baseweb.applications.shippingorder.repo.ProvinceRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressServiceImpl implements AddressService{

    @Autowired
    private ProvinceRepo provinceRepo;

    @Autowired
    private DistrictRepo districtRepo;

    @Autowired
    private CommuneRepo communeRepo;

    @Override
    public List<Province> getProvinces() {
        List<Province> provinces = provinceRepo.findAll();
        return provinces;
    }

    @Override
    public List<District> getRespectiveDistricts(String provinceId) {
        List<District> respectiveDistricts = districtRepo.findByProvinceId(provinceId);
        return respectiveDistricts;
    }

    @Override
    public List<Commune> getRespectiveCommunes(String districtId) {
        List<Commune> respectiveCommunes = communeRepo.findByDistrictId(districtId);
        return respectiveCommunes;
    }

    @Override
    public String getFullAddress(String communeId) {
        Commune commune = communeRepo.getById(communeId);
        District district = districtRepo.getById(commune.getDistrictId());

        return(", " + commune.getName() +
               ", " + district.getName() +
               ", " + provinceRepo.getById(district.getProvinceId()).getName());
    }
}
