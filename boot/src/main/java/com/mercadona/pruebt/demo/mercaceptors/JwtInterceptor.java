package com.mercadona.pruebt.demo.mercaceptors;

import com.mercadona.pruebt.demo.application.exceptions.AuthorizationException;
import com.mercadona.pruebt.demo.application.exceptions.ErrorCode;
import com.mercadona.pruebt.demo.application.lib.JwtUtils;
import io.jsonwebtoken.Claims;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import java.util.List;

@Component
public class JwtInterceptor implements HandlerInterceptor {

  @Override
  public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
    String authHeader = request.getHeader("Authorization");

    if (authHeader == null || !authHeader.startsWith("Bearer ")) {
      response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
      throw new AuthorizationException(ErrorCode.UNAUTHORIZED_MISSING_TOKEN);
    }

    String token = authHeader.substring(7);

    try {
      Claims claims = JwtUtils.validateToken(token);
      setSecurityContext(claims);
      request.setAttribute("username", claims.getSubject());
    } catch (Exception e) {
      response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
      throw new AuthorizationException(ErrorCode.UNAUTHORIZED_INVALID_TOKEN);
    }

    return true;
  }

  private static void setSecurityContext(Claims claims) {
    String role = claims.get("role", String.class);
    if (role != null) {
      List<GrantedAuthority> authorities = List.of(new SimpleGrantedAuthority("ROLE_" + role));

      UsernamePasswordAuthenticationToken authentication =
        new UsernamePasswordAuthenticationToken(claims.getSubject(),
          null, authorities);
      SecurityContextHolder.getContext().setAuthentication(authentication);
    }
  }
}
