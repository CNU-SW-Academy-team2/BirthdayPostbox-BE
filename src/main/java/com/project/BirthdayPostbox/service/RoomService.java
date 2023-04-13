package com.project.BirthdayPostbox.service;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.project.BirthdayPostbox.Exception.ErrorCode;
import com.project.BirthdayPostbox.Exception.ErrorCreate;
import com.project.BirthdayPostbox.Exception.RestApiException;
import com.project.BirthdayPostbox.dto.MessageDTO;
import com.project.BirthdayPostbox.dto.PresentDTO;
import com.project.BirthdayPostbox.dto.RoomDTO;
import com.project.BirthdayPostbox.entity.RoomEntity;
import com.project.BirthdayPostbox.repository.RoomRepository;
import com.project.BirthdayPostbox.util.EntityConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import static com.project.BirthdayPostbox.util.RoomIdCreate.createRandomId;

@Service
public class RoomService {
    @Autowired
    private RoomRepository roomRepository;
    @Autowired
    private MessageService messageService;
    @Autowired
    private PresentService presentService;
    @Autowired
    EntityConverter entityConverter;

    public String saveRoomInfo(RoomDTO roomDTO) {
        if(!checkRoomCountOver(roomDTO.getRoomEmail())) {
            //한 계정당 생성한 방이 5개를 초과하는지 확인하고 아니라면 방 생성 진행
            String RoomID = createRandomId().toString();
            roomDTO.setRoomId(RoomID);
            RoomEntity roomEntity = RoomEntity.toSaveEntity(roomDTO);
            roomRepository.save(roomEntity);
            return RoomID;
        }else {
            throw new ErrorCreate(String.format("방 생성 가능 횟수 초과된 email [email: %s]", roomDTO.getRoomEmail()));
        }
    }
    public boolean checkRoomCountOver(String email) {
        int count = roomRepository.countByroomEmail(email);
        if (count >= 5) {
            return true;
        }else {
            return false;
        }
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
        obj.addProperty("room_category", roomDTO.getRoomCategory().toString());
        obj.add("messages", jsonMessageArray);
        obj.add("presents", jsonPresentArray);
        return obj;
    }
    public RoomDTO findById(String roomId) {
        if(!roomRepository.findById(roomId).isEmpty()) {
            Optional<RoomEntity> optionalRoomEntity = roomRepository.findById(roomId);
            if(optionalRoomEntity.isPresent()) {
                RoomEntity roomEntity = optionalRoomEntity.get();
                RoomDTO roomDTO = entityConverter.converRoomDto(roomEntity);
                return roomDTO;
            }else {
                return null;
            }
        }else {
            throw new RestApiException(ErrorCode.ROOM_NOT_FOUND);
        }
    }

    /*****************************************************************************************/
    @Autowired
    EmailService emailService;
    @Scheduled(cron = "0 0 0 * * *", zone = "Asia/Seoul") //매일 0시마다 실행, 매분 실행: "0 * * * * *"
    public void generateOwnerCode() {
        Collection<RoomEntity> roomEntities = roomRepository.findByRoomBirthdate(new Date());
        for (RoomEntity roomEntity : roomEntities) {
            roomEntity.setOwnerCode(createRandomId().toString());
            emailService.sendEmail(roomEntity.getRoomEmail(), roomEntity.getOwnerCode());
        }
    }
}
