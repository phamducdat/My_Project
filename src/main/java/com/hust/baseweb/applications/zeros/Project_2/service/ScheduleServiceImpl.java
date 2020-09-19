package com.hust.baseweb.applications.zeros.Project_2.service;

import com.hust.baseweb.applications.zeros.Project_2.entity.Institute;
import com.hust.baseweb.applications.zeros.Project_2.entity.Subject;
import com.hust.baseweb.applications.zeros.Project_2.repo.InstituteRepo;
import com.hust.baseweb.applications.zeros.Project_2.repo.SubjectRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ScheduleServiceImpl implements ScheduleService {

    @Autowired
    private InstituteRepo instituteRepo;

    @Autowired
    private SubjectRepo subjectRepo;



    @Override
    public List<Institute> getInstitute() {

        List<Institute> institutes = instituteRepo.findAll();
        return institutes;
    }

    @Override
    public List<Subject> getRespectiteSubject(String instituteId) {
        List<Subject> respectiteSubjcts = subjectRepo.findByInstituteId(instituteId);

        return respectiteSubjcts;
    }

    @Override
    public String getFullAddress(String subjectId) {
        Subject subject = subjectRepo.getById(subjectId);

        return (", " + subject.getName() +
                ", " + subject.getDay() +
                ", " + instituteRepo.getById(subject.getInstituteId()).getName());
    }
}
