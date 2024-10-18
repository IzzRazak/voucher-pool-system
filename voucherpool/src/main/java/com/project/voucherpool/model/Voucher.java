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
    private Long voucherID;

    private Long offerID;

    private Long recipientID;

    private String code;

    private String usage;

    private Date expirationDate;

    private Date usedAt;

    private Date createdAt;

    private Date lastUpdAt;
}

