package com.project.BirthdayPostbox.controller;

import com.project.BirthdayPostbox.dto.MessageDTO;
import com.project.BirthdayPostbox.entity.Message;
import com.project.BirthdayPostbox.entity.Present;
import com.project.BirthdayPostbox.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MessageController {

    @Autowired
    MessageService service;

    @RequestMapping("message")
    public MessageDTO showMessage(@RequestParam("id") String msg_id) throws Exception {
        return service.showMessage(msg_id);
    }
}
