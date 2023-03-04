package com.project.BirthdayPostbox.converter;

import com.project.BirthdayPostbox.dto.MessageDTO;
import com.project.BirthdayPostbox.entity.Message;
import org.springframework.stereotype.Component;

@Component
public class EntityConverter {
    //dto -> entity
    public Message converMessage(MessageDTO messageDTO) {
        Message message = new Message();
        //추후 수정
        return message;
    }

    //entity -> dto
    public MessageDTO convertMessageDto(Message message) {
        return MessageDTO.builder()
                .messageId(message.getMessageId())
                .messageSender(message.getMessageSender())
                .messageContent(message.getMessageContent())
                .build();
    }

}
