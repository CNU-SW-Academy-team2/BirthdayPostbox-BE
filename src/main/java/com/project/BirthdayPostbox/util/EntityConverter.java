package com.project.BirthdayPostbox.util;

import com.project.BirthdayPostbox.dto.MessageDTO;
import com.project.BirthdayPostbox.dto.PresentDTO;
import com.project.BirthdayPostbox.dto.RoomDTO;
import com.project.BirthdayPostbox.entity.MessageEntity;
import com.project.BirthdayPostbox.entity.PresentEntity;
import com.project.BirthdayPostbox.entity.RoomEntity;
import org.springframework.stereotype.Component;

@Component
public class EntityConverter {

    //dto -> entity
//    public Room convertRoom(RoomDTO roomDTO) {
//        Room room = new Room();
//        room.setRoomId(roomDTO.getRoomId());
//        room.setRoomEmail(roomDTO.getRoomEmail());
//        room.setRoomName(roomDTO.getRoomName());
//        //room.setRoomBirthdate(roomDTO.getRoomBirthdate());
//        room.setOwnerCode(roomDTO.getOwnerCode());
//        return room;
//    }

    public MessageEntity convertMessage(MessageDTO messageDTO) {
        MessageEntity messageEntity = new MessageEntity();
        messageEntity.setMessageId(messageDTO.getMessageId());
        messageEntity.setMessageSender(messageDTO.getMessageSender());
        messageEntity.setMessageContent(messageDTO.getMessageContent());
        messageEntity.setRoom(RoomEntity.toSaveEntity(messageDTO.getRoomDTO()));
        return messageEntity;
    }

    public PresentEntity convertPresent(PresentDTO presentDTO) {
        PresentEntity presentEntity = new PresentEntity();
        presentEntity.setPresentId(presentDTO.getPresentId());
        presentEntity.setPresentSender(presentDTO.getPresentSender());
        presentEntity.setPresentContent(presentDTO.getPresentContent());
        presentEntity.setPresentImgUrl(presentDTO.getPresentImgUrl());
        presentEntity.setRoom(RoomEntity.toSaveEntity(presentDTO.getRoomDTO()));
        return presentEntity;
    }

    //entity -> dto
//    public RoomDTO convertRoomDto(Room room){
//        return RoomDTO.builder()
//                .roomId(room.getRoomId())
//                .roomName(room.getRoomName())
//                .roomEmail(room.getRoomEmail())
//                //.roomBirthdate(room.getRoomBirthdate())
//                .ownerCode(room.getOwnerCode())
//                .build();
//    }

    public MessageDTO convertMessageDto(MessageEntity messageEntity) {

        return MessageDTO.builder()
                .messageId(messageEntity.getMessageId())
                .messageSender(messageEntity.getMessageSender())
                .messageContent(messageEntity.getMessageContent())
                .roomDTO(converRoomDto(messageEntity.getRoom()))
                .build();
    }

    public PresentDTO convertPresentDto(PresentEntity presentEntity) {
        return PresentDTO.builder()
                .presentId(presentEntity.getPresentId())
                .presentSender(presentEntity.getPresentSender())
                .presentContent(presentEntity.getPresentContent())
                .presentImgUrl(presentEntity.getPresentImgUrl())
                .roomDTO(converRoomDto(presentEntity.getRoom()))
                .build();
    }
    public RoomDTO converRoomDto(RoomEntity room) {
        return RoomDTO.builder()
                .roomId(room.getId())
                .roomBirthdate(room.getRoomBirthdate())
                .roomEmail(room.getRoomEmail())
                .roomName(room.getRoomName())
                .ownerCode(room.getOwnerCode())
                .build();
    }
}
