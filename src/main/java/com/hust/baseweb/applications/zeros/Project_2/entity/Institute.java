package com.hust.baseweb.applications.zeros.Project_2.entity;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Getter
@Setter
public class Institute {
    @Id
    @Column(name = "institute_id")
    private String id;
    @Column(name = "institute_name")
    private String name;
}
