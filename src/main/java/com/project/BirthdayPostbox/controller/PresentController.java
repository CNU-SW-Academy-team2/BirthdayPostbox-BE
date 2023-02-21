package com.project.BirthdayPostbox.controller;

import com.project.BirthdayPostbox.service.PresentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PresentController {

    @Autowired
    private PresentService presentService;

}
