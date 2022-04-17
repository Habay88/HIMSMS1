//package com.habay.security;
//
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.builders.WebSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//
//@EnableWebSecurity
//public class SecurityConfig extends WebSecurityConfigurerAdapter {
////
////	@Value("${service.security.secure-key-username}")
////	private String SECURE_KEY_USERNAME;
////	
////	@Value("${service.security.secure-key-password}")
////	private String SECURE_KEY_PASSWORD;
//
//	@Value("${service.security.secure-key-username}")
//	private String SECURE_KEY_USERNAME;
//	
//	@Value("${service.security.secure-key-password}")
//	private String SECURE_KEY_PASSWORD;
//	@Override
//	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//		PasswordEncoder encoder = new BCryptPasswordEncoder();
//		auth.inMemoryAuthentication()
//		.passwordEncoder(encoder)
//		.withUser( SECURE_KEY_USERNAME)
//	//	.withUser("user") after config of app pppties
//	//	.password(encoder.encode("password"))
//		.password(encoder.encode(SECURE_KEY_PASSWORD))
//		.roles("USER");
//		//super.configure(auth);
//	}
//
//	@Override
//	public void configure(HttpSecurity http) throws Exception {
//		// TODO Auto-generated method stub
//		super.configure(http);
//		http.csrf().disable();
//	}
//
//}
