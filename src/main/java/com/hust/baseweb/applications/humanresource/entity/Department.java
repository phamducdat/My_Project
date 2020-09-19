package com.hust.baseweb.applications.humanresource.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Department {
	@Id
	@Column (name = "department_id")
	private String departmentId;
	
	@Column (name = "department_name")
	private String departmentName;
}
