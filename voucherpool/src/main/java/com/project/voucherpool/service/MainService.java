package com.project.voucherpool.service;

import com.project.voucherpool.model.Offer;
import com.project.voucherpool.model.Recipient;
import com.project.voucherpool.model.Voucher;
import com.project.voucherpool.repository.OfferRepository;
import com.project.voucherpool.repository.RecipientRepository;
import com.project.voucherpool.repository.VoucherRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.Random;

@Slf4j
@Service
public class MainService {
    @Autowired
    OfferRepository offerRepository;

    @Autowired
    RecipientRepository recipientRepository;

    @Autowired
    VoucherRepository voucherRepository;

    public static final int CODE_LENGTH = 10;

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

    public String generateVoucher(Long varId, LocalDate varDate) {
        Optional<Offer> offer = offerRepository.findById(varId);
        String formattedDate = LocalDate.now().format(DateTimeFormatter.ofPattern("yyyyMMdd"));

        List<Recipient> recipientList = recipientRepository.findAll();

        try {
            recipientList.stream().forEach(recipient -> {
                String randomChars = formattedDate + recipient.getName() + recipient.getEmail() + offer.get().getName();
                randomChars = randomChars.replaceAll("[^a-zA-Z0-9]", "");
                randomChars = randomChars.toUpperCase();
                log.info("[INFO] Service : randomChars => {}", randomChars);

                String voucherCode = generateRandomCode(randomChars);

                log.info("[INFO] Service : voucher code => {}", voucherCode);

                Voucher voucher = new Voucher();
                voucher.setCode(voucherCode);
                voucher.setRecipientID(recipient.getRecipientID());
                voucher.setOfferID(varId);
                voucher.setExpirationDate(varDate);
                voucher.setCreatedAt(new Date());
                voucher.setLastUpdAt(new Date());

                voucherRepository.save(voucher);
            });
        } catch (Exception e) {
            log.info("[ERROR] Service : generateVoucher => {}", e.getMessage());
        }


        return "";
    }

    public String generateRandomCode(String baseChars) {
        StringBuffer code = new StringBuffer(CODE_LENGTH);
        Random rdm = new Random();
        var codeLength = CODE_LENGTH;

        for (int i = 0; i < codeLength; i++) {
            int randomIndex = rdm.nextInt(baseChars.length());
            char randomChar = baseChars.charAt(randomIndex);
            code.append(randomChar);
        }

        return code.toString();
    }
}
