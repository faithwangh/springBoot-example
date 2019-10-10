package com.example.springbootservletfilter.filter;

import lombok.extern.slf4j.Slf4j;

import javax.servlet.*;
import java.io.IOException;

@Slf4j
public class MyFilter2 implements Filter {

  @Override
  public void doFilter(
      ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
      throws IOException, ServletException {

    log.error("myFilter2-->dofilter");
    filterChain.doFilter(servletRequest, servletResponse);
  }

  @Override
  public void init(FilterConfig filterConfig) throws ServletException {

    log.error("MyFilter2-->init");
  }

  @Override
  public void destroy() {

    log.error("MyFilter2-->destroy");
  }
}
