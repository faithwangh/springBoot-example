package com.example.springbootservletfilter.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Slf4j
@RestController
public class HelloController {

  @GetMapping("/hello")
  public Cookie[] hello(HttpServletRequest request) {

    System.out.println(request.getSession().getId());

    request.getSession().setAttribute("test", "test-name");

    System.out.println(request.getSession().getAttribute("test"));

    return request.getCookies();
  }

}
