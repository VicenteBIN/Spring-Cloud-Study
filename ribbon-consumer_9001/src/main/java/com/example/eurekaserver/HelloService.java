package com.example.eurekaserver;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class HelloService {

    private  final Logger logger=  Logger.getLogger(getClass());
    @Autowired
    private RestTemplate restTemplate;

    @HystrixCommand(fallbackMethod = "helloFallBack")
   public String helloService(){
        String body = restTemplate.getForEntity("http://HELLO-SERVICE/hello", String.class).getBody();
        return body;
   }

   public String helloFallBack(){
        return "error";
   }
}
