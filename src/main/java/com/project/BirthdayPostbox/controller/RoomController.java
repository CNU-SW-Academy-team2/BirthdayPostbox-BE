package com.project.BirthdayPostbox.controller;

import com.project.BirthdayPostbox.dto.RoomDTO;
import com.project.BirthdayPostbox.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
public class RoomController {

    @Autowired
    private RoomService roomService;

    @PostMapping("new-room")
    public String save(@ModelAttribute RoomDTO roomDTO) {
        System.out.println("room = " + roomDTO);
        return roomService.save(roomDTO);
    }
}
