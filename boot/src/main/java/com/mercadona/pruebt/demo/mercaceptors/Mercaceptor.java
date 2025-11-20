package com.mercadona.pruebt.demo.mercaceptors;

import com.mercadona.pruebt.demo.config.JwtInterceptor;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@RequiredArgsConstructor
public class Mercaceptor implements WebMvcConfigurer {

  private final LocaleMercaceptor localeInterceptor;
  private final JwtInterceptor jwtInterceptor;

  @Override
  public void addInterceptors(InterceptorRegistry registry) {
    registry.addInterceptor(localeInterceptor).order(Integer.MAX_VALUE);
    registry.addInterceptor(jwtInterceptor).addPathPatterns("/api/v1/**")
      .excludePathPatterns("/auth/**");
  }
}
