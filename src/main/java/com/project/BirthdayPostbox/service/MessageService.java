package com.project.BirthdayPostbox.service;

import com.project.BirthdayPostbox.util.EntityConverter;
import com.project.BirthdayPostbox.dto.MessageDTO;
import com.project.BirthdayPostbox.entity.MessageEntity;
import com.project.BirthdayPostbox.repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service
public class MessageService {

    @Autowired
    MessageRepository repository;

    @Autowired
    EntityConverter entityConverter;

    public MessageDTO showMessage(String msg_id) throws Exception {
        return repository.findById(msg_id).
                map(entityConverter::convertMessageDto)
                .orElseThrow(() -> new Exception("메세지를 찾을 수 없습니다."));
    }
    public List<MessageDTO> findByRoomId(String roomId) {
        Collection<MessageEntity> messageEntities = repository.findByroom_id(roomId);
        List<MessageDTO> messageDTOList = new ArrayList<>();
        for(MessageEntity messageEntity : messageEntities) {
            MessageDTO messageDTO = entityConverter.convertMessageDto(messageEntity);
            messageDTOList.add(messageDTO);
        }
        return messageDTOList;
    }
}
