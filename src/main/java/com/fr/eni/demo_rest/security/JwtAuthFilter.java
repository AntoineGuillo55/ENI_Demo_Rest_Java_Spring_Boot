package com.fr.eni.demo_rest.security;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fr.eni.demo_rest.service.AuthService;
import com.fr.eni.demo_rest.service.ServiceHelper;
import com.fr.eni.demo_rest.service.ServiceResponse;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
public class JwtAuthFilter extends OncePerRequestFilter {

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    AuthService authService;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {

        String url = request.getRequestURI();

        if(!url.startsWith("/api/create-token")){

            String token = request.getHeader("Authorization");

            ServiceResponse<Boolean> serviceResponse = authService.checkToken(token);

            if (!serviceResponse.code.equals("202")) {

                response.setContentType("application/json");

                objectMapper.writeValue(response.getWriter(), serviceResponse);

                return;
            }
        }

        //passer
        filterChain.doFilter(request, response);
    }
}
