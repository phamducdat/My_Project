package com.hust.baseweb.applications.zeros.Project_1.repo;

import com.hust.baseweb.applications.zeros.Project_1.entity.English;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface EnglishRepo extends JpaRepository<English, UUID> {

    English save(English eng);
    English getByEnglishName(String name);
    English getByVietnamName(String name);
    English getByPronounce(String name);
}
