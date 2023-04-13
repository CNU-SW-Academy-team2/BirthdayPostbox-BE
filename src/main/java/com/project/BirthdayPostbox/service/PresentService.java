package com.project.BirthdayPostbox.service;

import com.google.gson.JsonObject;
import com.project.BirthdayPostbox.Exception.ErrorCode;
import com.project.BirthdayPostbox.Exception.RestApiException;
import com.project.BirthdayPostbox.util.EntityConverter;
import com.project.BirthdayPostbox.dto.PresentDTO;
import com.project.BirthdayPostbox.entity.PresentEntity;
import com.project.BirthdayPostbox.repository.PresentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Random;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

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

    public JsonObject showPresent(String present_id, String owner_code) {
        PresentDTO presentDTO = repository.findById(present_id)
                .map(entityConverter::convertPresentDto)
                .orElseThrow(() -> new RestApiException(ErrorCode.PRESENT_NOT_FOUND));
        if (presentDTO.getRoomDTO().getOwnerCode() == owner_code) {
            JsonObject presentDTOobj = new JsonObject();
            presentDTOobj.addProperty("present_id", presentDTO.getPresentId());
            presentDTOobj.addProperty("present_sender", presentDTO.getPresentSender());
            presentDTOobj.addProperty("present_content", presentDTO.getPresentContent());
            presentDTOobj.addProperty("present_img_url", presentDTO.getPresentImgUrl());
            presentDTOobj.addProperty("room_category", presentDTO.getRoomDTO().getRoomCategory().toString());
            return presentDTOobj;
        }
        else {
            throw new RestApiException(ErrorCode.OWNER_CODE_NOT_MATCHED);
        }
    }

    public StringBuffer createId() {
        Random rnd = new Random();
        StringBuffer buf = new StringBuffer();

        for (int i = 0; i < 6; i++) {
            if (rnd.nextBoolean()) {
                buf.append((char) ((int) (rnd.nextInt(26)) + 97));
            } else {
                buf.append((rnd.nextInt(10)));
            }
        }
        return buf;

    }

    public List<PresentDTO> findByRoomId(String roomId) {
        Collection<PresentEntity> presentEntities = repository.findByroom_id(roomId);
        List<PresentDTO> presentDTOList = new ArrayList<>();
        for(PresentEntity presentEntity : presentEntities) {
            PresentDTO presentDTO = entityConverter.convertPresentDto(presentEntity);
            presentDTOList.add(presentDTO);
        }
        return presentDTOList;

    }
}
