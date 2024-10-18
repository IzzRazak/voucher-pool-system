package com.project.voucherpool.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

import java.lang.Long;
import java.math.BigDecimal;
import java.util.Date;


@Setter
@Getter
@Entity

public class Offer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long offerID;

    private String name;

    private BigDecimal percentageDiscount;

    private Date createdAt;

    private Date lastUpdAt;
}

