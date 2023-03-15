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

    public static MessageDTO toMessageDTO(MessageEntity messageEntity) {
        MessageDTO messageDTO = new MessageDTO();
        messageDTO.setMessageId(messageEntity.getMessageId());
        messageDTO.setMessageSender(messageEntity.getMessageSender());
        messageDTO.setMessageContent(messageEntity.getMessageSender());

        return messageDTO;
    }
}
