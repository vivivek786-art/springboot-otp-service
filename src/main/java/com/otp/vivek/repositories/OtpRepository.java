package com.otp.vivek.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.otp.vivek.entities.OtpEntity;

@Repository
public interface OtpRepository extends JpaRepository<OtpEntity, Long> {

	OtpEntity findByMobileAndOtpAndStatus(String mobile, String otp, Integer status);

}