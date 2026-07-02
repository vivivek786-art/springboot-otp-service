package com.otp.vivek.controller;

import java.util.Map;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.otp.vivek.controller.services.OtpService;
import com.otp.vivek.dto.OtpRequest;
import com.otp.vivek.dto.VerifyOtpRequest;

@RestController
@RequestMapping("/api/v1/otp")
public class OtpController {

	private final OtpService otpService;

	OtpController(OtpService otpService) {
		this.otpService = otpService;
	}

	@PostMapping("/send")
	public Map<String, Object> sendOtp(@RequestBody OtpRequest request) {

		System.out.println(System.getProperty("java.version"));
		System.out.println(System.getProperty("java.home"));
		return otpService.sendOtp(request.getMobile());

	}

	@PostMapping("/verify")
	public String verifyOtp(@RequestBody VerifyOtpRequest request) {

		return otpService.verifyOtp(request.getMobile(), request.getOtp());

	}

}