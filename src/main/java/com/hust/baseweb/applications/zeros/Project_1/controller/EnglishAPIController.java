package com.hust.baseweb.applications.zeros.Project_1.controller;


import com.hust.baseweb.applications.zeros.Project_1.entity.English;
import com.hust.baseweb.applications.zeros.Project_1.model.CreateEnglishInputModel;
import com.hust.baseweb.applications.zeros.Project_1.model.InputName;
import com.hust.baseweb.applications.zeros.Project_1.service.EnglishService;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
import java.util.List;

@Getter
@Setter
@RestController

public class EnglishAPIController {

    @Autowired
    private EnglishService englishService;


    @PostMapping("/create-english")
    public ResponseEntity<?> createEnglish(Principal principal, @RequestBody CreateEnglishInputModel input){
        English eng = englishService.save(input.getEnglishName(), input.getPronounce(), input.getVietnamName());
        return ResponseEntity.ok().body(eng);
    }

    @GetMapping("/get-all-english")
    public ResponseEntity<?> getAllEnglish(Principal principal){
        List<English> engs = englishService.findAll();
        return ResponseEntity.ok().body(engs);
    }

    @GetMapping("/remove-all-english")
    public ResponseEntity<?> removeAllEnglish(Principal principal){
        List<English> engs = englishService.removeAll();
        return ResponseEntity.ok().body(engs);
    }

    @PostMapping("/remove-english-by-name")
    public ResponseEntity<?> removeEnglishByName(Principal principal, @RequestBody InputName input){
        English eng = englishService.removeByEnglishName(input.getName());
        return ResponseEntity.ok().body(eng);
    }

    @PostMapping("/update-english")
    public ResponseEntity<?> updateEnglish(Principal principal, @RequestBody CreateEnglishInputModel inputModel){
        List<English> english = englishService.update(inputModel.getEnglishName(), inputModel.getPronounce(), inputModel.getVietnamName());
        return ResponseEntity.ok().body(english);
    }








}
