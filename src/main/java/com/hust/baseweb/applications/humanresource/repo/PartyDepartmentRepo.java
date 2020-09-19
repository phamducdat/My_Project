package com.hust.baseweb.applications.humanresource.repo;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hust.baseweb.applications.humanresource.entity.PartyDepartment;
import com.hust.baseweb.entity.Party;

public interface PartyDepartmentRepo extends JpaRepository<PartyDepartment, UUID> {
	PartyDepartment save(PartyDepartment partyDepartment);
	
	List<PartyDepartment> findByPartyAndThruDate(Party party, Date thruDate);
}
