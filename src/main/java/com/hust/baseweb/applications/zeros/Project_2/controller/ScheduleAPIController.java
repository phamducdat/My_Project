package com.hust.baseweb.applications.zeros.Project_2.controller;


import com.hust.baseweb.applications.zeros.Project_2.entity.Institute;
import com.hust.baseweb.applications.zeros.Project_2.entity.Subject;
import com.hust.baseweb.applications.zeros.Project_2.model.GetSubjectInputModel;
import com.hust.baseweb.applications.zeros.Project_2.service.ScheduleService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@RestController
@Log4j2
public class ScheduleAPIController {
    @Autowired
    private ScheduleService addressService;


    @GetMapping("/get-instistutes")
    public ResponseEntity<?> getInstiutes(Principal principal){
        log.info("Get all institutes");
        List<Institute> instituteList = addressService.getInstitute();
        return  ResponseEntity.ok().body(instituteList);
    }

    @PostMapping("/get-respective-subjects")
    public ResponseEntity<?> getRespectiveSubjects(Principal principal, @RequestBody GetSubjectInputModel getSubjectInputModel){
        List<Subject> subjects = addressService.getRespectiteSubject(getSubjectInputModel.getId());
        return ResponseEntity.ok().body(subjects);
    }
}
