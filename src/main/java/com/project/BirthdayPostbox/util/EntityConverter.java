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
    public MessageEntity converMessage(MessageDTO messageDTO) {
        MessageEntity message = new MessageEntity();
        //추후 수정
        return message;
    }

    //entity -> dto
    public MessageDTO convertMessageDto(MessageEntity message) {
        return MessageDTO.builder()
                .messageId(message.getMessageId())
                .messageSender(message.getMessageSender())
                .messageContent(message.getMessageContent())
                .build();
    }

    public PresentDTO convertPresentDto(PresentEntity present) {
        return PresentDTO.builder()
                .presentId(present.getPresentId())
                .presentSender(present.getPresentSender())
                .presentContent(present.getPresentContent())
                .presentUrl(present.getPresentImgUrl())
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
