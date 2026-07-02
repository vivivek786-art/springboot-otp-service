package com.otp.vivek.controller.services;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;
@Service
public class TwilioProvider implements SmsProvider {

	  @Value("${twilio.phone.number}")
	    private String fromNumber;

	    @Override
	    public void sendSms(String mobile, String message) {

	        Message.creator(
	                new PhoneNumber("+91" + mobile),
	                new PhoneNumber(fromNumber),
	                message
	        ).create();

	    }
}