package com.book.sellergoods.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/sellergoods")
public class SellergoodsController {

    @Autowired
    private DiscoveryClient discoveryClient;

    @RequestMapping("sayHello")
    public String sqyHello(){
        return "hello springcloud 哈哈哈！" + discoveryClient.getServices();
    }

}
