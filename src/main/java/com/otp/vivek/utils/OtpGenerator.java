package com.otp.vivek.utils;

import java.util.Random;

import org.springframework.stereotype.Component;

@Component
public class OtpGenerator {

    public String generateOtp() {

        return String.format("%06d",
                new Random().nextInt(1000000));

    }
}