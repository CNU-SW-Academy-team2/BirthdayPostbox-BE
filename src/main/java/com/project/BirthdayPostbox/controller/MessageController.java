package com.project.BirthdayPostbox.controller;

import com.google.gson.JsonObject;
import com.project.BirthdayPostbox.dto.MessageDTO;
import com.project.BirthdayPostbox.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class MessageController {

    @Autowired
    MessageService service;

    @RequestMapping(value = "new-message", method = RequestMethod.POST)
    public String newMessage(@RequestBody MessageDTO messageDTO) {
        return service.newMessage(messageDTO);
    }

    @RequestMapping("message")
    public JsonObject showMessage(@RequestParam("id") String msg_id, @RequestParam("owner_code") String owner_code) {
        return service.showMessage(msg_id, owner_code);
    }
}
