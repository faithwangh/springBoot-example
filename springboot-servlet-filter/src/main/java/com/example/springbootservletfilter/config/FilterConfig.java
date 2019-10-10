package com.example.springbootservletfilter.config;

import com.example.springbootservletfilter.filter.MyFilter1;
import com.example.springbootservletfilter.filter.MyFilter2;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.Filter;

@Configuration
public class FilterConfig {

  @Bean
  public FilterRegistrationBean filterRegistrationBean1() {
    FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean();
    filterRegistrationBean.setFilter(filter1());
    filterRegistrationBean.setName("myFilter1");
    filterRegistrationBean.addUrlPatterns("/*");
    //doFilter 在第1个
    filterRegistrationBean.setOrder(1);
    return filterRegistrationBean;
  }

  @Bean
  public FilterRegistrationBean filterRegistrationBean2() {
    FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean();
    filterRegistrationBean.setFilter(filter2());
    filterRegistrationBean.setName("myFilter2");
    filterRegistrationBean.addUrlPatterns("/*");
    //        filterRegistrationBean.setUrlPatterns();
      //        doFilter 在第2个
    filterRegistrationBean.setOrder(2);
    return filterRegistrationBean;
  }

  @Bean
  public Filter filter1() {
    return new MyFilter1();
  }

  @Bean
  public Filter filter2() {
    return new MyFilter2();
  }
}
