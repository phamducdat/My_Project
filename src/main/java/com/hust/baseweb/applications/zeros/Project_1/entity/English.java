package com.hust.baseweb.applications.zeros.Project_1.entity;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.UUID;

@Getter
@Setter
@Entity
public class English {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "english_id")
    private UUID englishId;

    @Column(name = "english_name")
    private String englishName;

    @Column(name = "pronounce")
    private String pronounce;

    @Column(name = "vietnam_name")
    private String vietnamName;

    public void setNull(){
        this.setPronounce(null);
        this.setVietnamName(null);
    }

    public void setAll(String vietnamName, String pronounce){
        this.vietnamName = vietnamName;
        this.pronounce = pronounce;
    }

}
