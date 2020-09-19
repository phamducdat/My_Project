package com.hust.baseweb.applications.zeros.Project_2.repo;

import com.hust.baseweb.applications.zeros.Project_2.entity.Subject;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SubjectRepo extends JpaRepository<Subject,String> {
    List<Subject> findByInstituteId(String instituteId);
    Subject getById(String id);
}
