package com.hust.baseweb.applications.humanresource.model;

import java.util.UUID;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AddParty2DepartmentInputModel {
	private UUID partyId;
	private String departmentId;
}
