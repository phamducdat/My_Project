package com.hust.baseweb.applications.shippingorder.service;

import com.hust.baseweb.applications.shippingorder.entity.ShippingOrder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ShippingOrderService {
    ShippingOrder save(ShippingOrder order);
    List<ShippingOrder> getListOrders();
}
