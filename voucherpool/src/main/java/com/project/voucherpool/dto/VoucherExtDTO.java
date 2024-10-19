package com.project.voucherpool.dto;

import com.project.voucherpool.model.Voucher;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Date;



@Getter
@Setter
public class VoucherExtDTO {

    private Voucher voucher;
    private String name;
    private BigDecimal percentageDiscount;
    private String email;

    public VoucherExtDTO(Voucher voucher, BigDecimal percentageDiscount, String name, String email) {
        this.voucher = voucher;
        this.percentageDiscount = percentageDiscount;
        this.name = name;
        this.email = email;
    }
}

