package com.project.BirthdayPostbox.service;

import com.project.BirthdayPostbox.repository.PresentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PresentService {

    @Autowired
    private PresentRepository presentRepository;

}
