package com.hust.baseweb.applications.zeros.Project_2.service;

import com.hust.baseweb.applications.zeros.Project_2.entity.Institute;
import com.hust.baseweb.applications.zeros.Project_2.entity.Subject;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ScheduleService {
    List<Institute> getInstitute();
    List<Subject> getRespectiteSubject(String instituteId);
    String getFullAddress(String subjectId);
}
