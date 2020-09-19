package com.hust.baseweb.applications.student.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateStudentInputModel {
	private String studentName;
	private String birthDate;
	private String email;
	private String gender;
	private String address;

}
