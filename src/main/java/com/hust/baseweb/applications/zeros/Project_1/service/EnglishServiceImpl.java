package com.hust.baseweb.applications.zeros.Project_1.service;

import com.hust.baseweb.applications.zeros.Project_1.entity.English;
import com.hust.baseweb.applications.zeros.Project_1.repo.EnglishRepo;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Log4j2
@Service
public class EnglishServiceImpl implements EnglishService {

    @Autowired
    private EnglishRepo englishRepo;

    @Override
    public English save(String englishName, String pronounce, String vietnamName) {
        English eng = new English();
        eng.setEnglishName(englishName);
        eng.setPronounce(pronounce);
        eng.setVietnamName(vietnamName);
        log.info(englishName + "jijji" + vietnamName + "fff" + pronounce);
        englishRepo.save(eng);

        return eng;
    }

    @Override
    public List<English> findAll() {
        List<English> engs = englishRepo.findAll();
        print();

        return engs;
    }

    @Override
    public List<English> removeAll() {
        englishRepo.deleteAll();
        List<English> eng = englishRepo.findAll();
        return eng;
    }

    public void print(){
        List<English> engs = englishRepo.findAll();
        for(English e : engs){
            log.info(e.getEnglishName()+ "    "  + e.getVietnamName() + "      " + e.getPronounce());
        }
    }

    public English save2(UUID uuid ,String englishName, String pronounce, String vietnamName){
        English english = new English();
        english.setEnglishId(uuid);
        english.setEnglishName(englishName);
        english.setPronounce(pronounce);
        english.setVietnamName(vietnamName);
        englishRepo.save(english);
        return english;
    }

    @Override
    public List<English> update(String englishName, String pronounce, String vietnamName) {
        English englishes = englishRepo.getByEnglishName(englishName);
        UUID uuid = englishes.getEnglishId();
        //englishRepo.delete(englishes);
        //save2(uuid ,englishName,pronounce,vietnamName);
        englishes.setEnglishName(englishName);
        englishes.setVietnamName(vietnamName);
        englishes.setPronounce(pronounce);
        englishRepo.save(englishes);
        List<English> englishes1 = englishRepo.findAll();
        return englishes1;
    }

    @Override
    public English removeByEnglishName(String name) {
        English eng = englishRepo.getByEnglishName(name);
        englishRepo.delete(eng);
        return null;
    }

    @Override
    public English findByName(String name) {
        English eng = englishRepo.getByEnglishName(name);
        return null;
    }

    @Override
    public English Test(String UUID) {
//        UUID uuid = UUID.
//        English english = englishRepo.getOne(UUID)
        return null;
    }
}
