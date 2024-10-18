package com.project.voucherpool.controller;

import com.project.voucherpool.model.Offer;
import com.project.voucherpool.model.Recipient;
import com.project.voucherpool.model.ResponseBody;
import com.project.voucherpool.model.Voucher;
import com.project.voucherpool.service.MainService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Slf4j
@RestController
public class DataController {
    @Autowired
    MainService mainService;

    @GetMapping("/getOffer")
    public List<Offer> getOffer() {
        return mainService.getOffer();
    }

    @GetMapping("/getValidVoucher")
    public List<Voucher> getValidVoucher() {
        return mainService.getValidVoucher();
    }

    @PostMapping("/submitRecipient")
    public ResponseEntity<ResponseBody> submitRecipient(@RequestParam Map<String, String> formData) {
        ResponseBody response = new ResponseBody();
        String name = formData.get("name");
        String email = formData.get("email");
        Recipient recipient = new Recipient();
        recipient.setName(name);
        recipient.setEmail(email);
        log.info("form received => name: {}, discount: {}", recipient.getName(), recipient.getEmail());
        response = mainService.saveRecipient(recipient);
        return new ResponseEntity<>(response, HttpStatusCode.valueOf(response.getStatusCode()));
    }

    @PostMapping("/generateVoucher")
    public ResponseEntity<ResponseBody> generateVoucher(@RequestParam("id") Long id,
                                                        @RequestParam("date") @DateTimeFormat(pattern = "yyyy-MM-dd") Date date) {
        mainService.generateVoucher(id, date);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/validateVoucher")
    public ResponseEntity<ResponseBody> validateVoucher(@RequestParam Map<String, String> formData) {
        ResponseBody response = new ResponseBody();
        String code = formData.get("code");
        String email = formData.get("email");
        response =  mainService.validateVoucher(code, email);
        return new ResponseEntity<>(response, HttpStatus.valueOf(response.getStatusCode()));
    }
}
