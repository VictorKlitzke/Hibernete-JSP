package com.fusion.prod.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class EcmController {

  @GetMapping("path")
  public String getMethodName(@RequestParam String param) {
    return "index";
  }

}
