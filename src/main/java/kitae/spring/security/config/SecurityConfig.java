package kitae.spring.security.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.httpBasic(Customizer.withDefaults());  // HTTP 기본 인증 사용
        http.authorizeHttpRequests(authorizeRequests ->
                authorizeRequests.anyRequest().authenticated());  // 모든 요청에 대해 인증 필요
        return http.build();
    }
}
