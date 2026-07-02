package com.otp.vivek.controller;


import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
@RestController
public class VoiceController {

    @GetMapping(value = "/voice", produces = MediaType.APPLICATION_XML_VALUE)
    public String voice(@RequestParam String otp) {

        return "<Response>" +
                "<Say voice=\"alice\">Your OTP is "
                + otp.charAt(0) + " "
                + otp.charAt(1) + " "
                + otp.charAt(2) + " "
                + otp.charAt(3) + " "
                + otp.charAt(4) + " "
                + otp.charAt(5)
                + "</Say>" +
                "</Response>";
    }
}
