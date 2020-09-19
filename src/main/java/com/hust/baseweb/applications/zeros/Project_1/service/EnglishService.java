package com.hust.baseweb.applications.zeros.Project_1.service;

import com.hust.baseweb.applications.zeros.Project_1.entity.English;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public interface EnglishService {

    English save(String englishName, String pronounce, String vietnamName);
    List<English> findAll();
    List<English> removeAll();
    List<English> update(String englishName, String pronounce, String vietnamName);
    English removeByEnglishName(String name);
    English findByName(String name);

    English Test(String UUID);

}
