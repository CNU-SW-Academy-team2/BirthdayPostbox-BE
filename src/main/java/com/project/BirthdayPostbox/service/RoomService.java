package com.project.BirthdayPostbox.service;

import com.project.BirthdayPostbox.dto.RoomDTO;
import com.project.BirthdayPostbox.entity.RoomEntity;
import com.project.BirthdayPostbox.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoomService {
    @Autowired
    private RoomRepository roomRepository;

    public void save(RoomDTO roomDTO) {
        RoomEntity roomEntity = RoomEntity.toSaveEntity(roomDTO);
        roomRepository.save(roomEntity);
    }
}
