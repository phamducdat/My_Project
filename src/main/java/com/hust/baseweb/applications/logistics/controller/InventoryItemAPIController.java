package com.hust.baseweb.applications.logistics.controller;

import com.hust.baseweb.applications.logistics.entity.InventoryItem;
import com.hust.baseweb.applications.logistics.model.ExportInventoryItemsInputModel;
import com.hust.baseweb.applications.logistics.model.ImportInventoryItemInputModel;
import com.hust.baseweb.applications.logistics.model.ImportInventoryItemsInputModel;
import com.hust.baseweb.applications.logistics.service.InventoryItemService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@RestController
@CrossOrigin
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class InventoryItemAPIController {
    public static final String module = InventoryItemAPIController.class.getName();

    InventoryItemService inventoryItemService;

    @PostMapping("/import-inventory-items")
    @Transactional
    public ResponseEntity importInventoryItems(Principal principal, @RequestBody ImportInventoryItemsInputModel input) {
//        System.out.println(module + "::importInventoryItems, input.sz = " + input.getInventoryItems().length);

        for (ImportInventoryItemInputModel inputModel : input.getInventoryItems()) {
            InventoryItem inventoryItem = inventoryItemService.importInventoryItem(inputModel);
            if (inventoryItem == null) {
                // THIS SHOULD BE IMPROVE using transaction
                return ResponseEntity.unprocessableEntity().body("cannot create inventory item");
            }
        }
        return ResponseEntity.ok().body("ok");
    }

    @PostMapping("/export-inventory-items")
    public ResponseEntity<?> exportInventoryItems(Principal principal,
                                                  @RequestBody ExportInventoryItemsInputModel input) {
        String response = inventoryItemService.exportInventoryItems(input);
        return ResponseEntity.ok().body(response);
    }

    @GetMapping("/get-inventory-order-header/page")
    public ResponseEntity<?> getInventoryOrderHeaderPage(Pageable pageable) {
        return ResponseEntity.ok().body(inventoryItemService.getInventoryOrderHeaderPage(pageable));
    }

    @GetMapping("/get-inventory-order-detail/{orderId}/all")
    public ResponseEntity<?> getInventoryOrderDetailPage(Pageable pageable, @PathVariable String orderId) {
        return ResponseEntity.ok().body(inventoryItemService.getInventoryOrderHeaderDetail(orderId));
    }
}
