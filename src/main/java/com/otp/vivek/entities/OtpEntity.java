package com.otp.vivek.entities;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "otp_details")
public class OtpEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String mobile;
	private String otp;

	private LocalDateTime createdAt;

	private LocalDateTime expiryTime;

	private Integer status;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getOtp() {
		return otp;
	}

	public void setOtp(String otp) {
		this.otp = otp;
	}

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}

	public LocalDateTime getExpiryTime() {
		return expiryTime;
	}

	public void setExpiryTime(LocalDateTime expiryTime) {
		this.expiryTime = expiryTime;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public OtpEntity(Long id, String mobile, String otp, LocalDateTime createdAt, LocalDateTime expiryTime,
			Integer status) {
		super();
		this.id = id;
		this.mobile = mobile;
		this.otp = otp;
		this.createdAt = createdAt;
		this.expiryTime = expiryTime;
		this.status = status;
	}

	public OtpEntity() {
		super();
	}

	@Override
	public String toString() {
		return "OtpEntity [id=" + id + ", mobile=" + mobile + ", otp=" + otp + ", createdAt=" + createdAt
				+ ", expiryTime=" + expiryTime + ", status=" + status + "]";
	}

}