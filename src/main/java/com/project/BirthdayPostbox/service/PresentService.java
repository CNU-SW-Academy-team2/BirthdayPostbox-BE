package com.project.BirthdayPostbox.service;

import com.project.BirthdayPostbox.converter.EntityConverter;
import com.project.BirthdayPostbox.dto.PresentDTO;
import com.project.BirthdayPostbox.entity.Present;
import com.project.BirthdayPostbox.repository.PresentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PresentService {
    @Autowired
    PresentRepository repository;

    @Autowired
    EntityConverter entityConverter;

    public void newPresent(PresentDTO presentDTO) {
        Present present = entityConverter.convertPresent(presentDTO);
        repository.save(present);
    }

    public PresentDTO showPresent(String present_id) throws Exception {
        return repository.findById(present_id)
                .map(entityConverter::convertPresentDto)
                .orElseThrow(() -> new Exception("메세지를 찾을 수 없습니다."));
    }

}
