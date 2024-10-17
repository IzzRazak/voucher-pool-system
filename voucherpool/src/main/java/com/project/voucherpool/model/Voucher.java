package com.project.voucherpool.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Date;


@Entity
@Getter
@Setter
public class Voucher {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long VoucherID;

    private Long OfferID;

    private Long RecipientID;

    private String Code;

    private LocalDate ExpirationDate;

    private Date CreatedAt;

    private Date LastUpdAt;
}

