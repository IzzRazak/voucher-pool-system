package com.project.voucherpool.controller;

import com.project.voucherpool.model.Offer;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
import com.project.voucherpool.model.Recipient;
import com.project.voucherpool.service.MainService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Slf4j
@Controller
public class MainController {

    @Autowired
    MainService mainService;

    // Display base page (home)
    @GetMapping("/home")
    public String homePage() {
        return "home";
    }
}
