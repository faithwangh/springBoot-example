package com.example.springbootservletfilter.filter;

import lombok.extern.slf4j.Slf4j;

import javax.servlet.*;
import java.io.IOException;

@Slf4j
public class MyFilter1 implements Filter {
  @Override
  public void doFilter(
      ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
      throws IOException, ServletException {

    log.error("myFilter1-->dofilter");
    filterChain.doFilter(servletRequest, servletResponse);
  }

  @Override
  public void init(FilterConfig filterConfig) throws ServletException {

    log.error("MyFilter1-->init");
  }

  @Override
  public void destroy() {

    log.error("MyFilter1-->destroy");
  }
}
