package com.project.BirthdayPostbox.service;

import com.project.BirthdayPostbox.util.EntityConverter;
import com.project.BirthdayPostbox.dto.MessageDTO;
import com.project.BirthdayPostbox.entity.MessageEntity;
import com.project.BirthdayPostbox.repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Random;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service
public class MessageService {

    @Autowired
    MessageRepository repository;

    @Autowired
    EntityConverter entityConverter;


    public void newMessage(MessageDTO messageDTO) {
        String randomId = createId().toString();
        while (repository.existsById(randomId)){
            randomId = createId().toString();
        }
        messageDTO.setMessageId(randomId);
        MessageEntity messageEntity = entityConverter.convertMessage(messageDTO);
        repository.save(messageEntity);
    }

    public MessageDTO showMessage(String msg_id) throws Exception {
        return repository.findById(msg_id).
                map(entityConverter::convertMessageDto)
                .orElseThrow(() -> new Exception("메세지를 찾을 수 없습니다."));
    }

    public StringBuffer createId() {
        Random rnd = new Random();
        StringBuffer buf = new StringBuffer();

        for (int i = 0; i < 6; i++) {
            if (rnd.nextBoolean()) {
                buf.append((char) ((int) (rnd.nextInt(26)) + 97));
            } else {
                buf.append((rnd.nextInt(10)));
            }
        }
        return buf;
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
