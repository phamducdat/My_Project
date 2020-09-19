package com.hust.baseweb.applications.shippingorder.controller;

import com.hust.baseweb.applications.shippingorder.entity.*;
import com.hust.baseweb.applications.shippingorder.model.CreateShippingOrderInputModel;
import com.hust.baseweb.applications.shippingorder.model.GetCommuneInputModel;
import com.hust.baseweb.applications.shippingorder.model.GetDistrictInputModel;
import com.hust.baseweb.applications.shippingorder.service.AddressService;
import com.hust.baseweb.applications.shippingorder.service.ShippingOrderService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@RestController
@Log4j2
public class ShippingOrderAPIController {

    @Autowired
    private ShippingOrderService service;

    @Autowired
    private AddressService addressService;

    @PostMapping("/create-shipping-order")
    public ResponseEntity<?> createShippingOrder(Principal principal, @RequestBody CreateShippingOrderInputModel input) {
        ShippingOrder order = new ShippingOrder();

        order.setSenderName(input.getSenderName());
        order.setSenderAddress(
                input.getSenderAddress() + addressService.getFullAddress(input.getSenderCommuneId()));
        order.setSenderPhoneNumber(input.getSenderPhoneNumber());
        order.setSenderCommuneId(input.getSenderCommuneId());

        order.setReceiverName(input.getReceiverName());
        order.setReceiverAddress(
                input.getReceiverAddress() + addressService.getFullAddress(input.getReceiverCommuneId()));
        order.setReceiverPhoneNumber(input.getReceiverPhoneNumber());
        order.setReceiverCommuneId(input.getReceiverCommuneId());

        order.setWeight(input.getWeight());
        order.setPackageName(input.getPackageName());

        order = service.save(order);

        return  ResponseEntity.ok().body(order);
    }

    @GetMapping("/get-all-shipping-orders")
    public ResponseEntity<?> getListOrders(Principal principal) {
        log.info("Get all shipping orders");
        List<ShippingOrder> listOrders = service.getListOrders();
        return ResponseEntity.ok().body(listOrders);
    }

    @GetMapping("/get-all-provinces")
    public ResponseEntity<?> getProvinces(Principal principal) {
        List<Province> provinces = addressService.getProvinces();
        return  ResponseEntity.ok().body(provinces);
    }

    @PostMapping("/get-respective-districts")
    public ResponseEntity<?> getRespectiveDistricts(Principal principal, @RequestBody GetDistrictInputModel input) {
        List<District> respectiveDistricts = addressService.getRespectiveDistricts(input.getId());
        return  ResponseEntity.ok().body(respectiveDistricts);
    }

    @PostMapping("/get-respective-communes")
    public ResponseEntity<?> getRespectiveCommunes(Principal principal, @RequestBody GetCommuneInputModel input) {
        List<Commune> respectiveCommunes = addressService.getRespectiveCommunes(input.getId());
        return ResponseEntity.ok().body(respectiveCommunes);
    }
}
