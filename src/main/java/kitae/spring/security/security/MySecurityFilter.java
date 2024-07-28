package kitae.spring.security.security;

import jakarta.servlet.*;

import java.io.IOException;

public class MySecurityFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("MySecurityFilter 실행 이전 ");
        filterChain.doFilter(servletRequest, servletResponse);
        System.out.println("MySecurityFilter 실행 이후 ");
    }
}
