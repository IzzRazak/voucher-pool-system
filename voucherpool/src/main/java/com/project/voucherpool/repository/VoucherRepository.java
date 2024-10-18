package com.project.voucherpool.repository;

import com.project.voucherpool.model.Recipient;
import com.project.voucherpool.model.Voucher;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface VoucherRepository extends JpaRepository<Voucher, Long> {
    Voucher findByCode(String code);

    List<Voucher> findByUsage(String usage);
}
