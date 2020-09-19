package com.hust.baseweb.applications.student.servicce;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hust.baseweb.applications.student.entity.Student;
import com.hust.baseweb.applications.student.repo.StudentRepo;

import lombok.extern.log4j.Log4j2;

@Log4j2
@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	private StudentRepo studentRepo;


	
	
	@Override
	public Student save(String studentName, String birthDate, String email, String gender, String address) {
		Student stu = new Student();
		stu.setStudentName(studentName);
		stu.setBirthDate(birthDate);
		stu.setEmail(email);
		stu.setGender(gender);
		stu.setAddress(address);
		stu = studentRepo.save(stu);
		log.info("kjhgfđfghjkl" + birthDate);
		return stu;
	}

	@Override
	public List<Student> findAll() {
		List<Student> students = studentRepo.findAll();

		for(Student s: students){
			log.info(s.getStudentName() + s.getEmail());
		}
		return students;
	}

	@Override
	public List<Student> removeAll() {
		studentRepo.deleteAll();
		List<Student> stus = studentRepo.findAll();
		return stus;
	}

	@Override
	public List<Student> removeByStudentName(String name) {
		List<Student> stus = studentRepo.getByStudentName(name);
		 for(Student s: stus){
		 	studentRepo.delete(s);
		 }
		 List<Student> stuss = studentRepo.findAll();
		return stuss;
	}

	@Override
	public List<Student> update(String studentName, String birthDate, String email, String gender, String address) {
		List<Student> stus = studentRepo.getByStudentName(studentName);
		if(stus.size() != 0) {
			for (Student s : stus) {
				s.setBirthDate(birthDate);
				s.setEmail(email);
				s.setGender(gender);
				s.setAddress(address);
				log.info("update " + studentName + email);
			}
		}

		return stus;
	}

}
