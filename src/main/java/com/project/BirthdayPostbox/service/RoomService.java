package com.project.BirthdayPostbox.service;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.project.BirthdayPostbox.Exception.ErrorCreate;
import com.project.BirthdayPostbox.dto.MessageDTO;
import com.project.BirthdayPostbox.dto.PresentDTO;
import com.project.BirthdayPostbox.dto.RoomDTO;
import com.project.BirthdayPostbox.entity.MessageEntity;
import com.project.BirthdayPostbox.entity.RoomEntity;
import com.project.BirthdayPostbox.repository.MessageRepository;
import com.project.BirthdayPostbox.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Random;

@Service
public class RoomService {
    @Autowired
    private RoomRepository roomRepository;
    @Autowired
    private MessageService messageService;
    @Autowired
    private PresentService presentService;
    public String saveRoom(RoomDTO roomDTO) {
        if(!checkEmailDuplicate(roomDTO.getRoomEmail())) {
            //email 중복 검사 후 해당 email의 계정이 존재하지 않는다면 방 생성 진행
            String RoomID = createRandomId().toString();
            roomDTO.setRoomId(RoomID);
            RoomEntity roomEntity = RoomEntity.toSaveEntity(roomDTO);
            roomRepository.save(roomEntity);
            return RoomID;
        }else {
            throw new ErrorCreate(String.format("중복된 email [email: %s]", roomDTO.getRoomEmail()));
        }
    }
    public boolean checkEmailDuplicate(String email) {
        return roomRepository.existsByroomEmail(email);
    }
    public StringBuffer createRandomId() {
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
    public JsonObject getRoomcontents(String roomId) {
        RoomDTO roomDTO = findById(roomId);

        List<MessageDTO> messageDTOList = messageService.findByRoomId(roomId);

        JsonArray jsonMessageArray = new JsonArray();
        for(MessageDTO messageDTO : messageDTOList) {
            JsonObject messageDTOobj = new JsonObject();
            messageDTOobj.addProperty("message_id", messageDTO.getMessageId());
            messageDTOobj.addProperty("message_sender", messageDTO.getMessageSender());
            jsonMessageArray.add(messageDTOobj);
        }

        List<PresentDTO> presentDTOList = presentService.findByRoomId(roomId);

        JsonArray jsonPresentArray = new JsonArray();
        for(PresentDTO presentDTO : presentDTOList) {
            JsonObject presentDTOobj = new JsonObject();
            presentDTOobj.addProperty("present_id", presentDTO.getPresentId());
            presentDTOobj.addProperty("present_sender", presentDTO.getPresentSender());
            jsonPresentArray.add(presentDTOobj);
        }

        JsonObject obj = new JsonObject();
        obj.addProperty("room_name", roomDTO.getRoomName());
        obj.addProperty("room_date", roomDTO.getRoomBirthdate().toString());
        obj.add("messages", jsonMessageArray);
        obj.add("presents", jsonPresentArray);
        return obj;
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
