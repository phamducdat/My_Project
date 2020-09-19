package com.hust.baseweb.applications.logistics.service;

import com.hust.baseweb.applications.logistics.entity.ProductType;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ProductTypeService {
    public List<ProductType> getAllProductType();

    public ProductType getProductTypeByProductTypeId(String productTypeId);
}
