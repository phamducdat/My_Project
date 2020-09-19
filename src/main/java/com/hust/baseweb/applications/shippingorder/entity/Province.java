package com.hust.baseweb.applications.shippingorder.entity;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CollectionId;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Getter
@Setter

public class Province {

    @Id
    @Column(name="province_id")
    private String id;

    @Column(name="province_name")
    private String name;
}
