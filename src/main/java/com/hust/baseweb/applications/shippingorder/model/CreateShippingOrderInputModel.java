package com.hust.baseweb.applications.shippingorder.model;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class CreateShippingOrderInputModel {

    private String senderName;
    private String senderPhoneNumber;
    private String senderAddress;
    private String senderCommuneId;

    private String receiverName;
    private String receiverPhoneNumber;
    private String receiverAddress;
    private String receiverCommuneId;

    private int weight;
    private String packageName;
}
