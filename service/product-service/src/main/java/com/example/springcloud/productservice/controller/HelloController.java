package com.example.springcloud.productservice.controller;

import com.example.springcloud.util.config.ServerConfig;
import com.example.springcloud.util.response.RestResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by wangyushuai@fang.com on 2018/12/12.
 */

@RestController
public class HelloController {

    @Autowired
    ServerConfig serverConfig;

    @RequestMapping({"/","/hello"})
    public RestResponse hello() {
        String message = String.format("welcome to product service! sever-%s:%s", serverConfig.getServerIp(),serverConfig.getServerPort());
        return RestResponse.buildSuccess(message);
    }
}

