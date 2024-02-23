package com.dailycodebuffer.springsecurityclient.config;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;

import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@EnableWebSecurity
@Configuration
public class WebSecurityConfig {

    private static final String[] WHITE_LIST_URLS = {
            "/hello",
            "/register",
            "/verifyRegistration",
            "/resendVerifyToken*",
            "/resetPassword",
            "/savePassword",
            "/changePassword"
    };

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http
                .csrf(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests(auth -> {
                    auth.requestMatchers(WHITE_LIST_URLS).permitAll();
                    auth.requestMatchers("/api/**")
                            .authenticated();
                })

                .oauth2Login(oauth2login ->
                        oauth2login.loginPage("/oauth2/authorization/api-client-oidc")) // Configure OAuth2 login
                .oauth2Client(Customizer.withDefaults()).build();

    }
}
//               .oauth2Login(oauth2login ->
//                       oauth2login.loginPage("/oauth2/authorization/api-client-oidc"))
////                .oauth2Client(Customizer.withDefaults());
////        return http.build();



//@Bean
//public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//        return http
//        .csrf(AbstractHttpConfigurer::disable)
//        .authorizeHttpRequests(authorizeRequests -> {
//        authorizeRequests
//        .antMatchers(WHITE_LIST_URLS).permitAll() // Permit access to whitelisted URLs
//        .antMatchers("/api/**").authenticated(); // Secure API endpoints
//        })
//        .oauth2Login(oauth2login ->
//        oauth2login.loginPage("/oauth2/authorization/api-client-oidc")) // Configure OAuth2 login
//        .oauth2Client(Customizer.withDefaults()) // Configure OAuth2 client
//        .and()
//        .build();
//        }


