package com.otp.vivek.dto;

public class OtpRequest {

	private String mobile;

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public OtpRequest(String mobile) {
		super();
		this.mobile = mobile;
	}

	public OtpRequest() {
		super();
	}

	@Override
	public String toString() {
		return "OtpRequest [mobile=" + mobile + "]";
	}

}
