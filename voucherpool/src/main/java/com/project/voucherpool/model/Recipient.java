package com.project.voucherpool.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Entity
@Getter
@Setter
public class Recipient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long recipientID;

    private String name;

    private String email;

    private Date createdAt;

    private Date lastUpdAt;
}

