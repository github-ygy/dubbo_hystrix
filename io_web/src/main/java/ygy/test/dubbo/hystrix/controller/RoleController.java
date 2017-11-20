package ygy.test.dubbo.hystrix.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ygy.test.dubbo.hystrix.service.role.RoleService;

/**
 * Created by guoyao on 2017/11/20.
 */
@RestController
public class RoleController {


    @Reference(version = "1.0.0")
    private RoleService roleService ;

    @RequestMapping("testConsumer")
    public Object testConsumer() {
        return roleService.getAllStudent();
    }

}
