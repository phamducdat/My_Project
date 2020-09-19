package com.hust.baseweb.applications.tracklocations.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.UUID;

@Entity
@Getter
@Setter
public class TrackLocations {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "track_location_id")
    private UUID trackLocationId;


    //@JoinColumn(name = "party_id", referencedColumnName = "party_id")
    //@OneToOne(fetch = FetchType.LAZY)
    //private Party party;

    @Column(name = "party_id")
    private UUID partyId;


    @Column(name = "location")
    private String location;

    @Column(name = "time_point")
    private Date timePoint;


    private Date createdStamp;
    private Date lastUpdatedStamp;

    public TrackLocations() {
        super();

    }


}
