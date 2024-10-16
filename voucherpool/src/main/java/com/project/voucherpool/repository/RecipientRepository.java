package com.project.voucherpool.repository;

import com.project.voucherpool.model.Offer;
import com.project.voucherpool.model.Recipient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RecipientRepository extends JpaRepository<Recipient, Long> {
}
