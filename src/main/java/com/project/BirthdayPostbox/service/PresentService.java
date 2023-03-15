package com.project.BirthdayPostbox.service;

import com.project.BirthdayPostbox.converter.EntityConverter;
import com.project.BirthdayPostbox.dto.PresentDTO;
import com.project.BirthdayPostbox.entity.PresentEntity;
import com.project.BirthdayPostbox.repository.PresentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service
public class PresentService {
    @Autowired
    PresentRepository repository;

    @Autowired
    EntityConverter entityConverter;

    public PresentDTO showPresent(String present_id) throws Exception {
        return repository.findById(present_id)
                .map(entityConverter::convertPresentDto)
                .orElseThrow(() -> new Exception("메세지를 찾을 수 없습니다."));
    }

    public List<PresentDTO> findByRoomId(String roomId) {
        Collection<PresentEntity> presentEntities = repository.findByroom_id(roomId);
        List<PresentDTO> presentDTOList = new ArrayList<>();
        for(PresentEntity presentEntity : presentEntities) {
            PresentDTO presentDTO = PresentDTO.toPresentDTO(presentEntity);
            presentDTOList.add(presentDTO);
        }
        return presentDTOList;
    }
}
