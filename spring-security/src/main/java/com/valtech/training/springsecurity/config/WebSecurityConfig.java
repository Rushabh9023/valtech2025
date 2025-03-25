package com.valtech.training.springsecurity.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class WebSecurityConfig {
	
	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity security)throws Exception {
		//write all config and then call build...
		
		// 1 ------->to allow everyone
//		security.authorizeHttpRequests(requests ->
//		requests.anyRequest().anonymous());
		
		// 2 ------>user must be authenticated
//		security.authorizeHttpRequests(requests ->
//		requests.requestMatchers("/hello").anonymous()
//		.requestMatchers("/admin").hasAnyRole("ADMIN")
//		.anyRequest().authenticated());
		
		//3 ---> form based login if success -> /user on failure -> /login
		
		security.authorizeHttpRequests(requests ->
		requests.requestMatchers("/hello","/login","register","/jsps/**").permitAll()
		.requestMatchers("/admin").hasAnyAuthority("ADMIN")
		.anyRequest().authenticated());
		
		security.cors(cors -> cors.disable());
		security.csrf(csrf -> csrf.disable());
		security.formLogin(formLogin -> formLogin.loginPage("/login").defaultSuccessUrl("/user")
				.failureForwardUrl("/login"));
		//4 --> automatic form basedlogin predefined loginpage 
//		security.csrf(csrf -> csrf.disable());
//		security.formLogin(formLogin -> formLogin.defaultSuccessUrl("/user")
//				.failureForwardUrl("/login"));
//		security.authorizeHttpRequests(requests ->
//		requests.requestMatchers("/hello","/login","/jsps/*").anonymous()
//		.requestMatchers("/admin").hasAnyRole("ADMIN")
//		.anyRequest().authenticated());
		
		
		return security.build();
	}
	
	
	// used when not want to work with database
//	@Bean
//	public UserDetailsManager userDetailsManager() {
//		InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
//		manager.createUser(User.builder().username("scott").password("tiger").roles("USER").build());
//		manager.createUser(User.builder().username("admin").password("admin").roles("USER","ADMIN").build());
//		return manager;
//	}
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
//		return NoOpPasswordEncoder.getInstance();
	}

}
