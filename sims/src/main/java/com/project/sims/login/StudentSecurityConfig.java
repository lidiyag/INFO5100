package com.project.sims.login;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@Order(2)
public class StudentSecurityConfig {
    @Bean
    public SecurityFilterChain filterChain2(HttpSecurity http) throws Exception{

        http.antMatcher("/student/**").authorizeRequests().anyRequest()
                .hasAuthority("STUDENT").and().formLogin().loginPage("/student/login").usernameParameter("email")
                .loginProcessingUrl("/student/login").defaultSuccessUrl("/student/home")
                .permitAll()
                .and()
                .logout().logoutUrl("/student/logout").logoutSuccessUrl("/");
        return http.build();

    }
}
