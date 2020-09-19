package com.hust.baseweb.applications.humanresource.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.hust.baseweb.applications.humanresource.entity.Department;
import com.hust.baseweb.applications.humanresource.entity.PartyDepartment;
import com.hust.baseweb.applications.humanresource.model.AddParty2DepartmentInputModel;
import com.hust.baseweb.applications.humanresource.model.CreateDepartmentModelInput;
import com.hust.baseweb.applications.humanresource.service.DepartmentService;
import com.hust.baseweb.applications.humanresource.service.PartyDepartmentService;
import com.hust.baseweb.applications.order.service.PartyCustomerService;
import com.hust.baseweb.entity.UserLogin;
import com.hust.baseweb.service.UserService;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Log4j2
@RestController	
@AllArgsConstructor (onConstructor = @__(@Autowired)) 
public class DepartmentAPIController {

	private DepartmentService departmentService;
	private UserService userService;
	private PartyDepartmentService partyDepartmentService;
	
	@PostMapping ("/create-department")
	public ResponseEntity<?> createDepartment(Principal principal, @RequestBody CreateDepartmentModelInput input){
		
		Department dept = departmentService.save(input.getDepartmentName());
		log.info("created department " + input.getDepartmentName());
		return ResponseEntity.ok().body(dept);
	}
	
	@GetMapping("/get-all-departments")
	public ResponseEntity<?> getAllDepartments(Principal principal){
		log.info("get all departments...");
		List<Department> depts = departmentService.findAll();
		return ResponseEntity.ok().body(depts);
	}
	
	@PostMapping("/add_user_2_department")
	public ResponseEntity<?> addUser2Department(Principal principal, @RequestBody AddParty2DepartmentInputModel input){
		UserLogin userLogin = userService.findById(principal.getName());
		log.info("add user 2 department, user login = " + userLogin.getUserLoginId());
		PartyDepartment partyDepartment = partyDepartmentService.save(input.getPartyId(), input.getDepartmentId());
		
		return ResponseEntity.ok().body("successfull");
	}
}
