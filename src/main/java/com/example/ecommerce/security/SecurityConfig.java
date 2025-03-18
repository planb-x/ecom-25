package com.example.ecommerce.security;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public InMemoryUserDetailsManager inMemoryUserDetailsManager() {

        UserDetails mary = User.builder().username("mary").password("{noop}mary123").roles("USER").build();
        UserDetails john = User.builder().username("john").password("{noop}john123").roles("USER","MANAGER").build();
        UserDetails adam = User.builder().username("adam").password("{noop}adam123").roles("USER","MANAGER","ADMIN").build();

        return new InMemoryUserDetailsManager(mary, john, adam);
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests(configurur -> configurur
                .requestMatchers(HttpMethod.GET,"/api/items").hasRole("USER")
                .requestMatchers(HttpMethod.POST,"/api/items").hasRole("MANAGER")
                .requestMatchers(HttpMethod.DELETE,"/api/items").hasRole("ADMIN"));
        http.httpBasic(Customizer.withDefaults());
        return http.build();
    }





}
