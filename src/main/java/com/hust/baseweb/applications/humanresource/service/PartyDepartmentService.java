package com.hust.baseweb.applications.humanresource.service;

import java.util.UUID;

import org.springframework.stereotype.Service;

import com.hust.baseweb.applications.humanresource.entity.PartyDepartment;

@Service
public interface PartyDepartmentService {
	PartyDepartment save(UUID partyId, String departmentID);
}
