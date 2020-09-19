package com.hust.baseweb.applications.humanresource.service;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hust.baseweb.applications.humanresource.entity.Department;
import com.hust.baseweb.applications.humanresource.entity.PartyDepartment;
import com.hust.baseweb.applications.humanresource.repo.DepartmentRepo;
import com.hust.baseweb.applications.humanresource.repo.PartyDepartmentRepo;
import com.hust.baseweb.entity.Party;
import com.hust.baseweb.repo.PartyRepo;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor (onConstructor = @__(@Autowired)) 
public class PartyDepartmentServiceImpl implements PartyDepartmentService {
	private PartyDepartmentRepo partyDepartmentRepo;
	private DepartmentRepo departmentRepo;
	private PartyRepo partyRepo;

	@Override
	public PartyDepartment save(UUID partyId, String departmentID) {
		// TODO Auto-generated method stub
		Department department = departmentRepo.findByDepartmentId(departmentID);
		Party party = partyRepo.findByPartyId(partyId);
		
		List<PartyDepartment> list = partyDepartmentRepo.findByPartyAndThruDate(party, null);
		for (PartyDepartment pd : list) {
			Date thruDate = new Date();
			pd.setThruDate(thruDate);
			partyDepartmentRepo.save(pd);
		}
		
		PartyDepartment partyDepartment = new PartyDepartment();
		partyDepartment.setParty(party);
		partyDepartment.setDepartment(department);
		
		Date fromDate = new Date(); // get current time
		partyDepartment.setFromDate(fromDate);
		
		partyDepartment = partyDepartmentRepo.save(partyDepartment);
		return partyDepartment;
	}

}
