package com.ctacolombia.CTACOLOMBIA.util.config.http;

import com.google.common.collect.ImmutableList;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

@Configuration
public class WebSecurityConfig {
    @Bean
    CorsConfigurationSource corsConfigurationSource() {
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        CorsConfiguration corsConfiguration= new CorsConfiguration();
        corsConfiguration.applyPermitDefaultValues();
        corsConfiguration.setAllowedOrigins(ImmutableList.of("**"));
        corsConfiguration.setAllowedMethods(ImmutableList.of("HEAD", "GET", "POST", "PUT", "DELETE", "PATCH","OPTIONS"));
        corsConfiguration.setAllowCredentials(true);
        corsConfiguration.setAllowedHeaders(ImmutableList.of("*","Access-Control-Allow-Origin: *","Date","Accept","X-Requested-With","From","X-Auth-Token","Request-Id","Authorization", "Cache-Control", "Content-Type","csrf_token"));
        corsConfiguration.setExposedHeaders(ImmutableList.of("Set-Cookie"));
        corsConfiguration.addAllowedOriginPattern("**");
        source.registerCorsConfiguration("/**", corsConfiguration);
        return source;
    }
}
