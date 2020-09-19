package com.hust.baseweb.applications.student.controller;

import java.security.Principal;
import java.util.List;

import com.hust.baseweb.applications.student.model.InputNameFind;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.hust.baseweb.applications.student.entity.Student;
import com.hust.baseweb.applications.student.model.CreateStudentInputModel;
import com.hust.baseweb.applications.student.servicce.StudentService;

import lombok.extern.log4j.Log4j2;

@RestController
@Log4j2
public class StudentAPIController {

	@Autowired
	private StudentService studentService;

	@PostMapping("/create-student")
	public ResponseEntity<?> createStudent(Principal principal, @RequestBody CreateStudentInputModel input) {
		log.info("createStudent, studentName = " + input.getStudentName());
		Student stu = studentService.save(input.getStudentName(), input.getBirthDate(),
				input.getEmail(), input.getGender(), input.getAddress());

		return ResponseEntity.ok().body(stu);
	}

	@GetMapping("/get-all-students")
	public ResponseEntity<?> getAllStudents(Principal principal) {
		log.info("getAllStudents..");
		List<Student> stus = studentService.findAll();
		return ResponseEntity.ok().body(stus);
	}

	@PostMapping("remove-students-by-name")
	public ResponseEntity<?> removeStudentsByName(Principal principal, @RequestBody InputNameFind input){
		log.info("removeStudentsByName..." + input.getName());
		List<Student> stus = studentService.removeByStudentName(input.getName());
		return ResponseEntity.ok().body(stus);
	}

	@GetMapping("remove-all-students")
	public ResponseEntity<?> removeAllStudents(Principal principal){
		List<Student> stus = studentService.removeAll();
		return ResponseEntity.ok().body(stus);
	}


	@PostMapping("/update-student")
	public ResponseEntity<?> updateStudnet(Principal principal, @RequestBody CreateStudentInputModel input){
		List<Student> stu = studentService.update(input.getStudentName(),input.getBirthDate(), input.getEmail()
										, input.getGender(), input.getAddress());

		return ResponseEntity.ok().body(stu);
	}

}
