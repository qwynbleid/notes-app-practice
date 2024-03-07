package com.spring.practice.notesservice.infrastructure.security;

//import jakarta.ws.rs.HttpMethod;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
//import org.springframework.security.config.http.SessionCreationPolicy;
//import org.springframework.security.web.SecurityFilterChain;
//import org.springframework.web.cors.CorsConfiguration;
//import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
//import java.util.Arrays;

//@Configuration
//@EnableWebSecurity
public class SecurityConfiguration {

//    @Bean
//    SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
//        http
//                .csrf(AbstractHttpConfigurer::disable)
//                .cors(cors -> cors.configurationSource(request -> {
//                    CorsConfiguration corsConfiguration = new CorsConfiguration();
//                    corsConfiguration.setAllowedOrigins(Arrays.asList("http://localhost:3000", "http://localhost:8765", "eureka/**"));
//                    corsConfiguration.setAllowedMethods(Arrays.asList("HEAD", "GET", "POST", "PUT", "DELETE", "PATCH", "OPTIONS"));
//                    corsConfiguration.setAllowedHeaders(Arrays.asList("X-Auth-Token", "Authorization", "Access-Control-Allow-Origin",
//                            "Access-Control-Allow-Credentials"));
//                    corsConfiguration.setAllowCredentials(true);
//                    corsConfiguration.setMaxAge(3600L);
//
//                    UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
//                    source.registerCorsConfiguration("/**", corsConfiguration);
//                    return corsConfiguration;
//                }))
//                .authorizeHttpRequests(req ->
//                        req
//                                .requestMatchers(HttpMethod.DELETE) // Додайте цей рядок для обробки DELETE-запитів
//                                .permitAll()
//                                .anyRequest()
//                                .permitAll())
//                .sessionManagement(session ->
//                        session.sessionCreationPolicy(SessionCreationPolicy.STATELESS));
//        return http.build();
//    }

}
