package com.otp.vivek.dto;

public class VerifyOtpRequest {

    private String mobile;

    private String otp;

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

	public VerifyOtpRequest(String mobile, String otp) {
		super();
		this.mobile = mobile;
		this.otp = otp;
	}

	public VerifyOtpRequest() {
		super();
	}

	@Override
	public String toString() {
		return "VerifyOtpRequest [mobile=" + mobile + ", otp=" + otp + "]";
	}
    
}
