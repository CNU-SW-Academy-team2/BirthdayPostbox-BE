package com.project.BirthdayPostbox.controller;

import com.project.BirthdayPostbox.dto.RoomDTO;
import com.project.BirthdayPostbox.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.google.gson.JsonObject;

@RestController
public class RoomController {

    @Autowired
    private RoomService roomService;

    //방 생성 api
    @PostMapping("new-room")
    public String save(@ModelAttribute RoomDTO roomDTO) {
//        System.out.println("room = " + roomDTO);
        return roomService.saveRoom(roomDTO);
    }
    @RequestMapping("room-content")
    public JsonObject getRoomcontents(@RequestParam("room_id") String room_id) {
        JsonObject returnJson = roomService.getRoomcontents(room_id);
        return returnJson;
    }
}
