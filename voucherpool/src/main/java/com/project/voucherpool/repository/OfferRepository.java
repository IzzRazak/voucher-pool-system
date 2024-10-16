package com.project.voucherpool.repository;

import com.project.voucherpool.model.Offer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface OfferRepository extends JpaRepository<Offer, Long> {

//    Optional<Offer> findOfferById(Long id);

}
