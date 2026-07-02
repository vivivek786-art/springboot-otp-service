package com.otp.vivek.controller.services;

import java.util.Map;

public interface OtpService {

    Map<String, Object> sendOtp(String mobile);

    String verifyOtp(String mobile,String otp);
    
    public void sendVoiceOtp(String mobile, String otp);


}