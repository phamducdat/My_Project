package com.hust.baseweb.applications.shippingorder.service;

import com.hust.baseweb.applications.shippingorder.entity.ShippingOrder;
import com.hust.baseweb.applications.shippingorder.repo.ShippingOrderRepo;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Log4j2
public class ShippingOrderServiceImpl implements ShippingOrderService {
    @Autowired
    private ShippingOrderRepo shippingOrderRepo;


    @Override
    public ShippingOrder save(ShippingOrder order) {
        log.info("Before saving order, id = " + order.getShippingOrderId());
        order = shippingOrderRepo.save(order);
        log.info("After saving order, id = " + order.getShippingOrderId());
        return order;
    }

    @Override
    public List<ShippingOrder> getListOrders() {
        List<ShippingOrder> listOrders = shippingOrderRepo.findAll();
        return listOrders;
    }
}
