package com.sg.stackovershow.jwt;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

public class AuthorizationToken  extends BasicAuthenticationFilter {
	
	private JwtTokenProvider jwtTokenProvider;
	
	public AuthorizationToken(AuthenticationManager authenticationManager,
                                  JwtTokenProvider tokenProvider) {
		super(authenticationManager);
        jwtTokenProvider = tokenProvider;
	}

	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws IOException, ServletException {
		
		Authentication authentication = jwtTokenProvider.getAuthentication(request);

        if(authentication !=null && jwtTokenProvider.validateToken(request)){
            SecurityContextHolder.getContext().setAuthentication(authentication);
        }
        chain.doFilter(request, response);
		
	}
	
	
}
