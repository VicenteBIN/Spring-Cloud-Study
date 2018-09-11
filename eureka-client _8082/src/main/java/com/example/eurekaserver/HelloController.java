package com.example.eurekaserver;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class HelloController {

    private  final Logger logger=  Logger.getLogger(getClass());
    @Autowired
    private DiscoveryClient discoveryClient;

    @RequestMapping(value="/hello",method = {RequestMethod.GET,RequestMethod.POST})
    public String hellow(){
        ServiceInstance localServiceInstance = discoveryClient.getLocalServiceInstance();
        logger.info("hello, host:"+localServiceInstance.getHost()+"service_id:"+localServiceInstance.getServiceId());
        return "Hellow World";
    }
}
