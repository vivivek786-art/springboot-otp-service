package com.otp.vivek;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.otp.vivek.utils.SslUtil;

@SpringBootApplication
public class VivekApplication {

	public static void main(String[] args) {
        SslUtil.disableSslVerification(); // only UAT testing
		SpringApplication.run(VivekApplication.class, args);
	}

}
