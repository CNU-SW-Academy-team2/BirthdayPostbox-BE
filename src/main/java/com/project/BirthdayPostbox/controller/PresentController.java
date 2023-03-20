package com.project.BirthdayPostbox.controller;

import com.project.BirthdayPostbox.dto.PresentDTO;
import com.project.BirthdayPostbox.service.PresentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class PresentController {

    @Autowired
    PresentService service;

    @RequestMapping(value = "new-present", method = RequestMethod.POST)
    public void newPresent(@RequestBody PresentDTO presentDTO) {
        service.newPresent(presentDTO);
    }

    @RequestMapping("present")
    public PresentDTO showPresent(@RequestParam("id") String present_id) throws Exception {
        System.out.println(present_id);
        return service.showPresent(present_id);
    }
}
