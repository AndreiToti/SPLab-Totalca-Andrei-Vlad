package org.example.filter;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.time.Instant;

public class RequestLoggingFilter implements Filter {

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
            throws IOException, ServletException {

        long startTime = System.currentTimeMillis();
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        String requestURI = request.getRequestURI();


        System.out.println("FILTER LOG: Request STARTED at " + Instant.now() +
                " | URI: " + requestURI + " | Method: " + request.getMethod());

        filterChain.doFilter(servletRequest, servletResponse);


        long duration = System.currentTimeMillis() - startTime;
        System.out.println("FILTER LOG: Request FINISHED at " + Instant.now() +
                " | URI: " + requestURI + " | Status: " + ((HttpServletRequest) servletRequest).getAttribute("jakarta.servlet.error.status_code") + // Tentativa de a prelua status code
                " | Duration: " + duration + "ms");
    }
}