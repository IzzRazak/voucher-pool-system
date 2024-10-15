package com.project.voucherpool.model;

import javax.annotation.processing.Generated;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.util.Date;

@Entity
public class Recepient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long RecipientID;

    private String Name;

    private String Email;

    private Date CreatedAt;

    private Date LastUpdAt;
}

