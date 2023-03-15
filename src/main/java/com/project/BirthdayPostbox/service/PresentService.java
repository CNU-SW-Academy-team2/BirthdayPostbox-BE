package com.project.BirthdayPostbox.service;

import com.project.BirthdayPostbox.converter.EntityConverter;
import com.project.BirthdayPostbox.dto.PresentDTO;
import com.project.BirthdayPostbox.entity.PresentEntity;
import com.project.BirthdayPostbox.repository.PresentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class PresentService {
    @Autowired
    PresentRepository repository;

    @Autowired
    EntityConverter entityConverter;

    public void newPresent(PresentDTO presentDTO) {
        String randomId = createId().toString();
        while (repository.existsById(randomId)){
            randomId = createId().toString();
        }
        presentDTO.setPresentId(randomId);
        PresentEntity presentEntity = entityConverter.convertPresent(presentDTO);
        repository.save(presentEntity);
    }

    public PresentDTO showPresent(String present_id) throws Exception {
        return repository.findById(present_id)
                .map(entityConverter::convertPresentDto)
                .orElseThrow(() -> new Exception("메세지를 찾을 수 없습니다."));
    }

    public StringBuffer createId() {
        Random rnd = new Random();
        StringBuffer buf = new StringBuffer();

        for(int i = 0; i < 6; i++) {
            if(rnd.nextBoolean()){
                buf.append((char)((int)(rnd.nextInt(26))+97));
            }else{
                buf.append((rnd.nextInt(10)));
            }
        }
        return buf;
    }
}
