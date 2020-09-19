package com.hust.baseweb.applications.student.repo;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hust.baseweb.applications.student.entity.Student;

public interface StudentRepo extends JpaRepository<Student, UUID> {
    Student save(Student stu);
    List<Student> getByStudentName(String name);
    @Override
    List<Student> findAll();
    //List<Student> deleteByStudentName(String name);

}
