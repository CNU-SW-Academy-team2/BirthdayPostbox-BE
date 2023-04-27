package com.project.BirthdayPostbox.controller;

import com.google.gson.JsonObject;
import com.project.BirthdayPostbox.dto.PresentDTO;
import com.project.BirthdayPostbox.service.PresentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
public class PresentController {

    @Autowired
    PresentService service;

    @PostMapping("new-present")
    public String newPresent(@ModelAttribute PresentDTO presentDTO, @RequestParam(value="image") MultipartFile image) throws IOException {
        System.out.println(presentDTO.getPresentId());
        System.out.println(presentDTO.getPresentSender());
        System.out.println(presentDTO.getPresentContent());
        System.out.println(presentDTO.getRoomDTO());
        System.out.println(presentDTO.getPresentDesign());
        System.out.println(presentDTO.getPresentImgUrl());
        System.out.println(image);
        return service.newPresent(image, presentDTO);
    }


    @RequestMapping("present")
    public JsonObject showPresent(@RequestParam("id") String present_id, @RequestParam("owner_code") String owner_code) {
        return service.showPresent(present_id, owner_code);
    }
}
