package com.book.sellergoods.controller;

import com.book.sellergoods.service.FeignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("sellergoods")
public class SellergoodsController {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private LoadBalancerClient loadBalancerClient;

    /**
     * 通过LoadBalancerClient获取指定服务的实例
     * @return
     */
    @RequestMapping("/consumer")
    public String consumer() {
        //负载均衡的选出一个eureka-client的服务实例
        ServiceInstance serviceInstance = loadBalancerClient.choose("book-sellergoods");

        String url = "http://" + serviceInstance.getHost() + ":" + serviceInstance.getPort() + "/sellergoods/sayHello";
        System.out.println(url);
        return restTemplate.getForObject(url, String.class);//转发到这个地址
    }

    /**
     * 通过服务消费（Ribbon）来转发
     * @return
     */
    @RequestMapping("ribbon")
    public String ribbon(){
        //服务名称+地址
        return restTemplate.getForObject("http://book-sellergoods/sellergoods/sayHello",String.class);
    }

    /**
     * 通过feign调用客户端
     */
    @Autowired
    private FeignService feignService;

    @RequestMapping("feign")
    public String feign(){
    return  feignService.Feign();
    }


}
