package com.project.BirthdayPostbox.controller;

import com.project.BirthdayPostbox.dto.PresentDTO;
import com.project.BirthdayPostbox.service.PresentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PresentController {

    @Autowired
    PresentService service;

    @RequestMapping("present")
    public PresentDTO showPresent(@RequestParam("id") String present_id) throws Exception {
        return service.showPresent(present_id);
    }
}
