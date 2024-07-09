package com.Trt.file_transferMp4;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.FormLoginConfigurer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration {
    //Güvenlik zinciri oluşturarak registryden oluşan isteklerin kontrolünden erişim izin verdik.
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        return httpSecurity
                .authorizeHttpRequests(registry ->{

                    registry.requestMatchers("home").permitAll();
                    registry.requestMatchers("/admin/**").hasRole("ADMIN");
                    registry.requestMatchers("/user/**").hasRole("USER");
                    registry.anyRequest().authenticated();
                })
                .formLogin(formLogin ->{
                    FormLoginConfigurer<HttpSecurity> httpSecurityFormLoginConfigurer = formLogin.permitAll();
                    ;})
                .build();
    }
    //Kullanci kimlikleriyla alakali birkac
    @Bean
    public UserDetailsService userDetailsService() {
        UserDetails normalUser= User.builder()
                .username("Melisa")
                .password("$2a$12$0kDo4pV3rOkdlsa3q0YXK.rI1VEB.Fp3BKuoS/6lvrjh0Whx2sVZO")
                .roles("USER")
                .build();
        UserDetails adminUser= User.builder()
                .username("Huso")
                .password("$2a$12$6JewjtvKMD1snYQHJafP0u2wCYjxJjkKrTE52QmmH.hJw.vrpnhAa")
                .roles("ADMIN","USER")
                .build();
        return new InMemoryUserDetailsManager(normalUser,adminUser);
    }
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}

