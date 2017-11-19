package ygy.test.dubbo.hystrix.service.helloworld.impl;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import ygy.test.dubbo.hystrix.service.helloworld.HelloWorldService;

/**
 * Created by guoyao on 2017/11/19.
 */
@Service("helloWorldService")
public class HelloWorldServiceImpl  implements HelloWorldService{

    @Value("${dubbo.hystrix.helloworld1}")
    private String serviceName1;
    @Value("${dubbo.hystrix.helloworld2}")
    private String serviceName2;
    //@Value("${dubbo.hystrix.helloworld3}")
    private String serviceName3;


    public String helloworld() {
        return "hellowolrd :" + serviceName1 + " :  " +serviceName2 + " : " + serviceName3;
    }

}
