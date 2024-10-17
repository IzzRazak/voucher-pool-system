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

//    private static final Log
//    ger log = LoggerFactory.getLogger(MainController.class);

    @GetMapping("/view")
    public String homePage() {
        return "home";
    }

    @PostMapping("/submitRecipient")
    public String submitOffer(@ModelAttribute Recipient recipient) {
        mainService.saveRecipient(recipient);
        log.info("form received => name: {}, email: {}", recipient.getName(), recipient.getEmail());
        return "redirect:/view";
    }

    @PostMapping("/submitOffer")
    public String submitRecipient(@ModelAttribute Offer offer) {
        mainService.saveOffer(offer);
        log.info("form received => name: {}, discount: {}", offer.getName(), offer.getPercentageDiscount());
        return "redirect:/view";
    }



//    @PostMapping("/submitOffer")
//    public String submitOffer(@RequestParam String name, @RequestParam String discount, @RequestParam("expirationDate") String expirationDate) {
//
//        log.info("form received => name: {}, discount: {}, expiry: {}", name, discount, expirationDate);
//        return "redirect:/home";
//    }
}
