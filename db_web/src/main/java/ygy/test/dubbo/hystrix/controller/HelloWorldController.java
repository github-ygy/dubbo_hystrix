package ygy.test.dubbo.hystrix.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ygy.test.dubbo.hystrix.service.helloworld.HelloWorldService;

/**
 * Created by guoyao on 2017/11/19.
 */

@RestController
public class HelloWorldController {

    @Autowired
    HelloWorldService helloWorldService;


    @RequestMapping("/helloworld")
    public Object helloworld() {

        return helloWorldService.helloworld();
    }

}
