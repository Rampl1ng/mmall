package com.rampling.mmall.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @Description :
 * @Author : Rampling
 * @Date : Created in 13:55 2021/02/06
 **/
@Controller
public class RedirectHandler {
    @GetMapping("/{url}")
    public String redirect(@PathVariable("url") String url) {
        return url;
    }
}
