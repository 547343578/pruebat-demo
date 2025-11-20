package com.mercadona.pruebt.demo.config;

import com.mercadona.pruebt.demo.application.exceptions.ErrorCode;
import com.mercadona.pruebt.demo.application.exceptions.PruebatException;
import com.mercadona.pruebt.demo.application.lib.JwtUtils;
import io.jsonwebtoken.Claims;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

@Component
public class JwtInterceptor implements HandlerInterceptor {

  @Override
  public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
    String authHeader = request.getHeader("Authorization");

    if (authHeader == null || !authHeader.startsWith("Bearer ")) {
      response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
      throw new PruebatException(ErrorCode.UNAUTHORIZED_MISSING_TOKEN);
    }

    String token = authHeader.substring(7);

    try {
      Claims claims = JwtUtils.validateToken(token);
      request.setAttribute("username", claims.getSubject());
    } catch (Exception e) {
      response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
      throw new PruebatException(ErrorCode.UNAUTHORIZED_INVALID_TOKEN);
    }

    return true;
  }
}
