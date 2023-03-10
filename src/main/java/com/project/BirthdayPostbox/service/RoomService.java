package com.project.BirthdayPostbox.service;

import ch.qos.logback.core.net.SyslogOutputStream;
import com.project.BirthdayPostbox.dto.RoomDTO;
import com.project.BirthdayPostbox.entity.RoomEntity;
import com.project.BirthdayPostbox.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Random;

@Service
public class RoomService {
    @Autowired
    private RoomRepository roomRepository;
    public String save(RoomDTO roomDTO) {
        String RoomID = createRoomid().toString();
        roomDTO.setRoomId(RoomID);
        RoomEntity roomEntity = RoomEntity.toSaveEntity(roomDTO);
        roomRepository.save(roomEntity);
        return RoomID;
    }
    public StringBuffer createRoomid() {
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
    public void getRoomcontents(String roomId) {
        RoomDTO roomDTO = findById(roomId);
        System.out.println(roomDTO);

        //TODO : room_id에 맞는 message 받아오기

        //TODO : room_id에 맞는 present 받아오기

        //TODO : return json으로
    }
    public RoomDTO findById(String roomId) {
        Optional<RoomEntity> optionalRoomEntity = roomRepository.findById(roomId);
        if(optionalRoomEntity.isPresent()) {
            RoomEntity roomEntity = optionalRoomEntity.get();
            RoomDTO roomDTO = RoomDTO.toRoomDTO(roomEntity);
            return roomDTO;
        }else {
            return null;
        }

    }
}
