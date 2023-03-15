package com.project.BirthdayPostbox.dto;

import com.project.BirthdayPostbox.entity.MessageEntity;
import lombok.*;
import org.aspectj.bridge.Message;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MessageDTO {
    private String messageId;
    private String messageSender;
    private String messageContent;
    private RoomDTO roomDTO;
    private String room_id;

    public static MessageDTO toMessageDTO(MessageEntity messageEntity) {
        MessageDTO messageDTO = new MessageDTO();
        messageDTO.setMessageId(messageEntity.getMessageId());
        messageDTO.setMessageSender(messageEntity.getMessageSender());
        messageDTO.setMessageContent(messageEntity.getMessageSender());
        messageDTO.setRoom_id(messageEntity.getMessageId());

        return messageDTO;
    }
}
