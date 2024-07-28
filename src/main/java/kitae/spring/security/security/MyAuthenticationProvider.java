package kitae.spring.security.security;

import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
public class MyAuthenticationProvider implements AuthenticationProvider {
    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String name = authentication.getName();
        String password = authentication.getCredentials().toString();
        if("test".equals(name) && "1111".equals(password)) {
            return new UsernamePasswordAuthenticationToken(name, password, Arrays.asList());
        } else {
            throw new BadCredentialsException("인증 실패 - 잘못된 사용자 정보");
        }
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return authentication.equals(UsernamePasswordAuthenticationToken.class);    // 인증 토큰이 UsernamePasswordAuthenticationToken 타입이면 true 반환
    }
}
