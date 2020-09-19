package com.hust.baseweb.applications.logistics.service;

import com.hust.baseweb.applications.logistics.entity.ProductPrice;
import com.hust.baseweb.entity.UserLogin;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;


@Service
public interface ProductPriceService {
    ProductPrice setProductPrice(UserLogin createdByUserLogin, String productId, BigDecimal price, String currencyUomId, String taxInPrice);

    ProductPrice getProductPrice(String productId);
}
