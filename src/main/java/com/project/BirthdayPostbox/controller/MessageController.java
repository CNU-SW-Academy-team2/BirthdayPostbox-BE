package com.project.BirthdayPostbox.controller;

import com.project.BirthdayPostbox.dto.MessageDTO;
import com.project.BirthdayPostbox.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class MessageController {

    @Autowired
    MessageService service;

    @RequestMapping(value = "new-message", method = RequestMethod.POST)
    public void newMessage(@ModelAttribute MessageDTO messageDTO) {
        System.out.println(messageDTO.getMessageSender());
        System.out.println(messageDTO.getMessageContent());
        System.out.println(messageDTO.getRoomDTO());
//        service.newMessage(messageDTO);
    }

    @RequestMapping("message")
    public MessageDTO showMessage(@RequestParam("id") String msg_id) throws Exception {
        return service.showMessage(msg_id);
    }
}
