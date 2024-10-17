package com.project.voucherpool.repository;

import com.project.voucherpool.model.Recipient;
import com.project.voucherpool.model.Voucher;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VoucherRepository extends JpaRepository<Voucher, Long> {
}
