package com.project.voucherpool.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Date;


@Controller
public class MainController {

    private static final Logger log = LoggerFactory.getLogger(MainController.class);

    @GetMapping("/view")
    public String homePage() {
        return "home";
    }
    @PostMapping("/submitOffer")
    public String submitOffer(@RequestParam String name, @RequestParam String discount, @RequestParam("expirationDate") String expirationDate) {
        log.info("form received => name: {}, discount: {}, expiry: {}", name, discount, expirationDate);
        return "redirect:/home";
    }
}
