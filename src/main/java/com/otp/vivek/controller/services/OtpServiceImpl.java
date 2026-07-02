package com.otp.vivek.controller.services;

import java.net.URI;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.otp.vivek.entities.OtpEntity;
import com.otp.vivek.repositories.OtpRepository;
import com.otp.vivek.utils.OtpGenerator;
import com.twilio.rest.api.v2010.account.Call;
import com.twilio.type.PhoneNumber;

@Service
public class OtpServiceImpl implements OtpService {

	private final OtpRepository otpRepository;
	private final OtpGenerator otpGenerator;
	private final SmsProvider smsProvider;

	OtpServiceImpl(OtpRepository otpRepository, OtpGenerator otpGenerator, SmsProvider smsProvider) {

		this.otpRepository = otpRepository;
		this.otpGenerator = otpGenerator;
		this.smsProvider = smsProvider;
	}

	@Override
	public Map<String, Object> sendOtp(String mobile) {

		String otp = otpGenerator.generateOtp();

		OtpEntity entity = new OtpEntity();

		entity.setMobile(mobile);
		entity.setOtp(otp);
		entity.setCreatedAt(LocalDateTime.now());
		entity.setExpiryTime(LocalDateTime.now().plusMinutes(5));
		entity.setStatus(0);

		otpRepository.save(entity);

		// Send SMS
		smsProvider.sendSms(mobile, "Your OTP is " + otp + ". Valid for 5 minutes.");

		Map<String, Object> response = new HashMap<>();
		response.put("message", "OTP sent successfully");

		return response;
	}

	@Override
	public String verifyOtp(String mobile, String otp) {

		OtpEntity data = otpRepository.findByMobileAndOtpAndStatus(mobile, otp, 0);

		if (data == null)
			return "Invalid OTP";

		if (data.getExpiryTime().isBefore(LocalDateTime.now()))
			return "OTP Expired";

		data.setStatus(1);

		otpRepository.save(data);

		return "OTP Verified";
	}

	public void sendVoiceOtp(String fromNumber, String otp) {

	    String url = "https://YOUR_DOMAIN/voice?otp=" + otp;

	    Call call = Call.creator(
	            new PhoneNumber("+91" + fromNumber),
	            new PhoneNumber(fromNumber),
	            URI.create(url))
	            .create();

	    System.out.println(call.getSid());
	}
}