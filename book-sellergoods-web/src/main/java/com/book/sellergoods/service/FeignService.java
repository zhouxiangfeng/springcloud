package com.book.sellergoods.service;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient("book-sellergoods")
public interface FeignService {

    @RequestMapping("/sellergoods/sayHello")
    String Feign();
}
