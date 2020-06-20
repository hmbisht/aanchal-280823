package com.simplified.aanchal.common.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Component;

@Component
public class RequestResponseFilter implements Filter {
  private static final Log log = LogFactory.getLog(RequestResponseFilter.class);

  @Override
  public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws ServletException, IOException {

    if (servletRequest instanceof HttpServletRequest) {
      HttpServletRequest httpRequest = (HttpServletRequest) servletRequest;

      String requestId = httpRequest.getHeader("x-request-id");
      String correlationId = httpRequest.getHeader("x-debug-id");

      log.info("Request received at RequestResponseFilter. x-request-id: " + requestId + ", x-debug-id: " + correlationId + ".");

      // Do something, may be add some string to identify the request gone through for Splunk etc.
      filterChain.doFilter(httpRequest, servletResponse);
    }
  }
}
