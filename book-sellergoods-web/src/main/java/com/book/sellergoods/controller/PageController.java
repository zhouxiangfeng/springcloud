package com.book.sellergoods.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PageController {

     /**
     * 用于页面跳转
     * @param page
     * @return
     */
    @RequestMapping("/{page}")
    public String pageController(@PathVariable("page") String page){
         return page;
    }

}
