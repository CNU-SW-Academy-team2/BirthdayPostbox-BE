package com.project.BirthdayPostbox.converter;

import com.project.BirthdayPostbox.dto.MessageDTO;
import com.project.BirthdayPostbox.dto.PresentDTO;
import com.project.BirthdayPostbox.entity.Message;
import com.project.BirthdayPostbox.entity.Present;
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

    public PresentDTO convertPresentDto(Present present) {
        return PresentDTO.builder()
                .presentId(present.getPresentId())
                .presentSender(present.getPresentSender())
                .presentContent(present.getPresentContent())
                .presentUrl(present.getPresentImgUrl())
                .build();
    }
}
