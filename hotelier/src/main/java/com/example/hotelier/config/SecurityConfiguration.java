package com.example.hotelier.config;

import com.example.hotelier.model.enums.UserRoleEnum;
import com.example.hotelier.repository.UserRepository;
import com.example.hotelier.service.impl.HotelierUserDetailsService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.security.servlet.PathRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.password.Pbkdf2PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableMethodSecurity
public class SecurityConfiguration {

//    private final String rememberMeKey;
//
//    public SecurityConfiguration(@Value("${hotelier.remember.me.key}")
//                                 String rememberMeKey) {
//        this.rememberMeKey = rememberMeKey;
//    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception {
      return httpSecurity.authorizeHttpRequests(
                authorizeRequests -> authorizeRequests
                        .requestMatchers(PathRequest.toStaticResources().atCommonLocations()).permitAll()
                        .requestMatchers("/", "/users/login", "/users/register", "/users/login-error").permitAll()
                        .requestMatchers("/offers/all").permitAll()
                        .requestMatchers(HttpMethod.GET,"/offers/all").permitAll()
                        .requestMatchers("/error").permitAll()
                        .requestMatchers("/hotelChains").hasRole(UserRoleEnum.ADMIN.name())
                        .anyRequest().authenticated()
        ).formLogin(
                formLogin -> {
                    formLogin.loginPage("/users/login")
                            .usernameParameter("email")
                            .passwordParameter("password")
                            .defaultSuccessUrl("/")
                            .failureForwardUrl("/users/login-error");
                }
        ).logout(
                logout -> {
                    logout
                            .logoutUrl("/users/logout")
                            .logoutSuccessUrl("/")
                            .invalidateHttpSession(true);
                }
//        ).rememberMe(
//                rememberMe -> {
//                    rememberMe
//                            .key(rememberMeKey)
//                            .rememberMeParameter("rememberme")
//                            .rememberMeCookieName("rememberme");
//                }
        ).build();

    }

    @Bean
    public UserDetailsService userDetailsService(UserRepository userRepository) {
        return new HotelierUserDetailsService(userRepository);
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
       return Pbkdf2PasswordEncoder.defaultsForSpringSecurity_v5_8();
    }

}
