package com.project.voucherpool.repository;

import com.project.voucherpool.model.Offer;
import com.project.voucherpool.model.Voucher;
import com.project.voucherpool.dto.VoucherExtDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface VoucherRepository extends JpaRepository<Voucher, Long> {
    Voucher findByCode(String code);

    List<Voucher> findByUsage(String usage);

    @Query("SELECT vc FROM Voucher vc WHERE " +
            "vc.code = :code AND vc.recipientID = "+
            "(SELECT rc.recipientID from Recipient rc WHERE rc.email = :email)")
    Optional<Voucher> findyByCodeAndEmail(@Param("code") String code,
                                            @Param("email") String email);

    @Query("SELECT ofr FROM Offer ofr WHERE ofr.offerID = :id")
    Offer findByOfferID(@Param("id") Long id);


    @Query("Select new com.project.voucherpool.dto.VoucherExtDTO(vcr, ofr.percentageDiscount, ofr.name, rcp.email) from Voucher vcr " +
            "INNER JOIN Offer ofr ON ofr.offerID = vcr.offerID " +
            "INNER JOIN Recipient rcp ON rcp.recipientID = vcr.recipientID " +
            "WHERE vcr.usage != 'Y'")
    List<VoucherExtDTO> findByValidVoucher();
}
