package com.rampling.mmall.controller;


import com.rampling.mmall.service.ProductCategoryService;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.ModelAndView;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author Rampling
 * @since 2021-02-06
 */
@Controller
@RequestMapping("/product_category")
public class ProductCategoryController {

    @Autowired
    private ProductCategoryService service;

    @GetMapping("/list")
    public ModelAndView list() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("main");
        modelAndView.addObject("list", service.getAllProductCategoryVO());
        return modelAndView;
    }
}

