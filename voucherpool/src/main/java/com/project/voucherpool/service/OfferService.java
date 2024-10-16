package com.project.voucherpool.service;

import com.project.voucherpool.model.Offer;
import com.project.voucherpool.model.Recipient;
import com.project.voucherpool.repository.OfferRepository;
import com.project.voucherpool.repository.RecipientRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class OfferService {
    @Autowired
    OfferRepository offerRepository;

    @Autowired
    RecipientRepository recipientRepository;

    public List<Offer> getOffer() {
        return offerRepository.findAll();
    }

    public Offer saveOffer(Offer offer) {
        offer.setCreatedAt(new Date());
        offer.setLastUpdAt(new Date());
        return offerRepository.save(offer);
    }

    public Recipient saveRecipient(Recipient recipient) {
        return recipientRepository.save(recipient);
    }

    public String generateVoucher(Long varId) {
        Optional<Offer> offer = offerRepository.findById(varId);
        String formattedDate = LocalDate.now().format(DateTimeFormatter.ofPattern("yyyyMMdd"));

        List<Recipient> recipientList = recipientRepository.findAll();

        recipientList.stream().forEach(recipient -> {
            String randomChars = formattedDate + recipient.getName() + recipient.getEmail() + offer.get().getName();
            randomChars = randomChars.replaceAll("[^a-zA-Z0-9]", "");
            log.info("[INFO] Service : randomChars => {}", randomChars);
        });

        return "";
    }
}
