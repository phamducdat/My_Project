package com.hust.baseweb.applications.shippingorder.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Getter
@Setter
@Table(name="district")
public class District {

    @Id
    @Column(name="district_id")
    private String id;

    @Column(name = "district_name")
    private String name;

    @Column(name = "province_id")
    private String provinceId;
}
