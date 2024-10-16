package com.project.voucherpool.controller;

import com.project.voucherpool.model.Offer;
import com.project.voucherpool.service.OfferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DataController {
    @Autowired
    OfferService offerService;

    @GetMapping("/getOffer")
    public List<Offer> getOffer() {
        return offerService.getOffer();
    }

    @PostMapping("/generateVoucher/{id}")
    public ResponseEntity<ResponseBody> generateVoucher(@PathVariable Long id) {
        offerService.generateVoucher(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
