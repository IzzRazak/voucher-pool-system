package com.project.voucherpool.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.util.Date;


@Entity
public class Voucher {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long VoucherID;

    private Long OfferID;

    private Long RecipientID;

    private String Code;

    private Date ExpirationDate;

    private Date CreatedAt;

    private Date LastUpdAt;
}

