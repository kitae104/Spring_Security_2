package kitae.spring.security.config;

import kitae.spring.security.security.MySecurityFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;
import org.springframework.web.bind.annotation.GetMapping;

@Configuration
public class SecurityConfig {

    // 메모리 기반의 사용자 상세 정보를 제공하는 UserDetailsService 빈을 생성
//    @Bean
//    public UserDetailsService userDetailsService() {
//        InMemoryUserDetailsManager userDetailsService = new InMemoryUserDetailsManager();
//        UserDetails user = User.withUsername("test")
//                .password(passwordEncoder().encode("1111")) // 패스워드 암호화
//                .authorities("read")
//                .build();
//        userDetailsService.createUser(user);
//        return userDetailsService;
//    }

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.httpBasic(Customizer.withDefaults());  // HTTP 기본 인증 사용
//        http.formLogin(Customizer.withDefaults());  // 폼 기반 로그인 사용
        http.authorizeHttpRequests(authorizeRequests ->
                authorizeRequests
                        .requestMatchers("/hello")
                        .authenticated()    // 요청에 대해 인증 필요
//                        .anyRequest()       // 나머지 요청에 대해
//                        .denyAll()        // 접근 거부
        );

        // 필터 적용
        http.addFilterBefore(new MySecurityFilter(), BasicAuthenticationFilter.class);
        return http.build();
    }
}
