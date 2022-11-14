package com.allodoc.tn.covibed.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.allodoc.tn.covibed.model.QrCodeDetail;

public interface IQrCodeDetailDao extends JpaRepository<QrCodeDetail, Long> {

}
