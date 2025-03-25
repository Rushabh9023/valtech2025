package com.valtech.training.sprsecoauth2;

import java.net.Authenticator.RequestorType;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity security) throws Exception{
		security.authorizeHttpRequests(request -> request.anyRequest().authenticated());
		security.oauth2Login(Customizer.withDefaults());
		return security.build();
	}
}
