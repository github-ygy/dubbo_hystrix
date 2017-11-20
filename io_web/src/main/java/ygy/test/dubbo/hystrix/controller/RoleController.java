package ygy.test.dubbo.hystrix.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ygy.test.dubbo.hystrix.service.role.RoleService;

/**
 * Created by guoyao on 2017/11/20.
 */
@RestController
public class RoleController {


    //@Reference(version = "1.0.0")   //开启dubbo注解是使用
    @Autowired
    private RoleService roleService ;   //使用xml 配置时，可用autowired注入

    @RequestMapping("testConsumer")
    public Object testConsumer() {
        return roleService.getAllStudent();
    }

}
