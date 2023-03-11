package com.project.BirthdayPostbox.converter;

import com.project.BirthdayPostbox.dto.MessageDTO;
import com.project.BirthdayPostbox.dto.PresentDTO;
import com.project.BirthdayPostbox.dto.RoomDTO;
import com.project.BirthdayPostbox.entity.Message;
import com.project.BirthdayPostbox.entity.Present;
import com.project.BirthdayPostbox.entity.Room;
import org.springframework.stereotype.Component;

@Component
public class EntityConverter {

    //dto -> entity
    public Room convertRoom(RoomDTO roomDTO) {
        Room room = new Room();
        room.setRoomId(roomDTO.getRoomId());
        room.setRoomEmail(roomDTO.getRoomEmail());
        room.setRoomName(roomDTO.getRoomName());
        //room.setRoomBirthdate(roomDTO.getRoomBirthdate());
        room.setOwnerCode(roomDTO.getOwnerCode());
        return room;
    }

    public Message convertMessage(MessageDTO messageDTO) {
        Message message = new Message();
        message.setMessageId(messageDTO.getMessageId());
        message.setMessageSender(messageDTO.getMessageSender());
        message.setMessageContent(messageDTO.getMessageContent());
        message.setRoom(convertRoom(messageDTO.getRoomDTO()));
        return message;
    }

    public Present convertPresent(PresentDTO presentDTO) {
        Present present = new Present();
        present.setPresentId(presentDTO.getPresentId());
        present.setPresentSender(presentDTO.getPresentSender());
        present.setPresentContent(presentDTO.getPresentContent());
        present.setPresentImgUrl(presentDTO.getPresentImgUrl());
        present.setRoom(convertRoom(presentDTO.getRoomDTO()));
        return present;
    }

    //entity -> dto
    public RoomDTO convertRoomDto(Room room){
        return RoomDTO.builder()
                .roomId(room.getRoomId())
                .roomName(room.getRoomName())
                .roomEmail(room.getRoomEmail())
                //.roomBirthdate(room.getRoomBirthdate())
                .ownerCode(room.getOwnerCode())
                .build();
    }

    public MessageDTO convertMessageDto(Message message) {
        return MessageDTO.builder()
                .messageId(message.getMessageId())
                .messageSender(message.getMessageSender())
                .messageContent(message.getMessageContent())
                .roomId(message.getRoom().getRoomId())
                .roomDTO(convertRoomDto(message.getRoom()))
                .build();
    }

    public PresentDTO convertPresentDto(Present present) {
        return PresentDTO.builder()
                .presentId(present.getPresentId())
                .presentSender(present.getPresentSender())
                .presentContent(present.getPresentContent())
                .presentImgUrl(present.getPresentImgUrl())
                .roomId(present.getRoom().getRoomId())
                .roomDTO(convertRoomDto(present.getRoom()))
                .build();
    }

}
