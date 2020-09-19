package com.hust.baseweb.applications.shippingorder.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Getter
@Setter
@Table(name = "ship_order")
public class ShippingOrder {
    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    @Column(name = "ship_order_id")
    private UUID shippingOrderId;

    @Column(name = "from_customer_name")
    private String senderName;

    @Column(name = "from_phone_num")
    private String senderPhoneNumber;

    @Column(name = "from_address")
    private String senderAddress;

    @Column(name = "from_commune_id")
    private String senderCommuneId;

    @Column(name = "to_customer_name")
    private String receiverName;

    @Column(name = "to_phone_num")
    private String receiverPhoneNumber;

    @Column(name = "to_address")
    private String receiverAddress;

    @Column(name = "to_commune_id")
    private String receiverCommuneId;

    @Column(name = "weight")
    private int weight;

    @Column(name = "package_name")
    private String packageName;
}
