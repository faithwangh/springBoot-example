package com.example.springbootservletfilter.filter;

import lombok.extern.slf4j.Slf4j;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

@Slf4j
@WebFilter(
    filterName = "customFilter",
    urlPatterns = {"/*"})
public class CustomFilter implements Filter {

  @Override
  public void doFilter(
      ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
      throws IOException, ServletException {

    log.error("customFilter --->dofilter");

    filterChain.doFilter(servletRequest, servletResponse);
  }

  @Override
  public void init(FilterConfig filterConfig) throws ServletException {
    log.error("customFilter --->filer init");
  }

  @Override
  public void destroy() {
    log.error("customFilter --->filter destroy");
  }
}
