package com.otp.vivek.controller.services;

import java.net.URI;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.twilio.rest.api.v2010.account.Call;
import com.twilio.type.PhoneNumber;
@Service
public class VoiceProvider {

    @Value("${twilio.phone.number}")
    private String fromNumber;

    public void sendVoiceOtp(String mobile, String otp) {

        String twiml =
                "<Response>" +
                "<Say voice=\"alice\">Your OTP is "
                + otp.charAt(0) + " "
                + otp.charAt(1) + " "
                + otp.charAt(2) + " "
                + otp.charAt(3) + " "
                + otp.charAt(4) + " "
                + otp.charAt(5)
                + "</Say>" +
                "</Response>";

        Call.creator(
                new PhoneNumber("+91" + mobile),
                new PhoneNumber(fromNumber),
                URI.create("http://demo.twilio.com/docs/voice.xml"))
                .create();
    }
}