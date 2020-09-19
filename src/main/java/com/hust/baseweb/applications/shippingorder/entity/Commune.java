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
@Table(name = "commune")
public class Commune {

    @Id
    @Column(name = "commune_id")
    private String id;

    @Column(name = "commune_name")
    private String name;

    @Column(name = "district_id")
    private String districtId;
}
