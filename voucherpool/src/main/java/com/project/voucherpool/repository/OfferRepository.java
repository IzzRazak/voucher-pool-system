package com.project.voucherpool.repository;

import com.project.voucherpool.model.Offer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface OfferRepository extends JpaRepository<Offer, Long> {

    @Query("SELECT ofr FROM Offer ofr WHERE ofr.offerID = :id")
    Offer findByOfferID(@Param("id") Long id);
}
