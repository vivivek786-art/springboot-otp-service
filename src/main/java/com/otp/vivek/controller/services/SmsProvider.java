package com.otp.vivek.controller.services;

public interface SmsProvider {
	void sendSms(String mobile, String message);
}
