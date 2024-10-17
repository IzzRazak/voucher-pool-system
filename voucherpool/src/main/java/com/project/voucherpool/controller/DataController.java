package com.project.voucherpool.controller;

import com.project.voucherpool.model.Offer;
import com.project.voucherpool.service.MainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
public class DataController {
    @Autowired
    MainService mainService;

    @GetMapping("/getOffer")
    public List<Offer> getOffer() {
        return mainService.getOffer();
    }

    @PostMapping("/generateVoucher")
    public ResponseEntity<ResponseBody> generateVoucher(@RequestParam("id") Long id,
                                                        @RequestParam("date") @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date) {
        mainService.generateVoucher(id, date);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
