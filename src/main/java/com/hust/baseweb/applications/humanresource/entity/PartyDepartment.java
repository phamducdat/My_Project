package com.hust.baseweb.applications.humanresource.entity;

import java.util.Date;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.hust.baseweb.entity.Party;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class PartyDepartment {
	
	@Id
	@Column (name = "party_department_id")
	@GeneratedValue(strategy = GenerationType.AUTO) 
	private UUID partyDepartmentId;
	
	@JoinColumn(name = "department_id", referencedColumnName = "department_id")
	@ManyToOne
	private Department department;
	
	@JoinColumn(name = "party_id", referencedColumnName = "party_id")
	@ManyToOne
	private Party party;
	
	@Column(name = "from_date")
	private Date fromDate;
	
	@Column(name = "thru_date")
	private Date thruDate;
}
