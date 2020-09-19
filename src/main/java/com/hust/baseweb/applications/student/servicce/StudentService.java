package com.hust.baseweb.applications.student.servicce;
 
import java.util.List;

import org.springframework.stereotype.Service;

import com.hust.baseweb.applications.student.entity.Student;
@Service
public interface StudentService {


	Student save(String studentName, String birthDate, String email, String gender, String address);
	List<Student> findAll();
	List<Student> removeAll();
	List<Student> removeByStudentName(String name);
	List<Student> update(String studentName, String birthDate, String email, String gender, String address);



	
}
