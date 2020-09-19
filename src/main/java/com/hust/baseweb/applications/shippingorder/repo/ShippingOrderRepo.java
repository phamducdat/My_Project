package com.hust.baseweb.applications.shippingorder.repo;

import com.hust.baseweb.applications.shippingorder.entity.ShippingOrder;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ShippingOrderRepo extends JpaRepository<ShippingOrder, UUID> {
    ShippingOrder save(ShippingOrder order);
}
