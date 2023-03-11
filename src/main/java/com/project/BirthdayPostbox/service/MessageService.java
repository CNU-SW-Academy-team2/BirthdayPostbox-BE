package com.project.BirthdayPostbox.service;

import com.project.BirthdayPostbox.converter.EntityConverter;
import com.project.BirthdayPostbox.dto.MessageDTO;
import com.project.BirthdayPostbox.entity.Message;
import com.project.BirthdayPostbox.repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MessageService {

    @Autowired
    MessageRepository repository;

    @Autowired
    EntityConverter entityConverter;


    public void newMessage(MessageDTO messageDTO) {
        Message message = entityConverter.convertMessage(messageDTO);
        repository.save(message);
    }

    public MessageDTO showMessage(String msg_id) throws Exception {
        return repository.findById(msg_id).
                map(entityConverter::convertMessageDto)
                .orElseThrow(() -> new Exception("메세지를 찾을 수 없습니다."));
    }
}
