package com.cognizant.techtalk.security;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@Configuration
public class UsernameAuthFilter extends OncePerRequestFilter {

    private static final Logger logger = LoggerFactory.getLogger(UsernameAuthFilter.class);
    private static final String AUTHORIZATION = "Authorization";
    private static final String BEARER = "Bearer";
    @Value("${techtalk.token}")
    private String token;

    @Override
    public void doFilterInternal(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse,
                                FilterChain filterChain) throws IOException, ServletException {
        String header = httpServletRequest.getHeader(AUTHORIZATION);
        logger.info("The header is : {}",header);
        if( header == null || !header.startsWith(BEARER)) {
            filterChain.doFilter(httpServletRequest, httpServletResponse);
            return;
        }
        UsernamePasswordAuthenticationToken authentication =  new UsernamePasswordAuthenticationToken("user", null, new ArrayList<>());

        if(authentication != null && header.contains(token)){

            authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(httpServletRequest));

            SecurityContextHolder.getContext().setAuthentication(authentication);
        }

        filterChain.doFilter(httpServletRequest, httpServletResponse);
    }


}
