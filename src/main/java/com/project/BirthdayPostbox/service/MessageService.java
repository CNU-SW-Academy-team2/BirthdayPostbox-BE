package com.project.BirthdayPostbox.service;

import com.project.BirthdayPostbox.converter.EntityConverter;
import com.project.BirthdayPostbox.dto.MessageDTO;
import com.project.BirthdayPostbox.dto.RoomDTO;
import com.project.BirthdayPostbox.entity.MessageEntity;
import com.project.BirthdayPostbox.entity.RoomEntity;
import com.project.BirthdayPostbox.repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

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
    public MessageDTO findByRoomId(String roomId) {
        Optional<MessageEntity> optionalMessageEntity = repository.findALL(roomId);
        if(optionalMessageEntity.isPresent()) {
            MessageEntity messageEntity = optionalMessageEntity.get();
            MessageDTO messageDTO = MessageDTO.toMessageDTO(messageEntity);
            return messageDTO;
        }else {
            return null;
        }
    }
}
