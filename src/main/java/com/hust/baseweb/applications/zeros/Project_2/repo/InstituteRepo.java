package com.hust.baseweb.applications.zeros.Project_2.repo;

import com.hust.baseweb.applications.zeros.Project_2.entity.Institute;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InstituteRepo extends JpaRepository<Institute,String> {
    Institute getById(String id);
}
