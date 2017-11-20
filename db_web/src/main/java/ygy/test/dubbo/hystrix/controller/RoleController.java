package ygy.test.dubbo.hystrix.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ygy.test.dubbo.hystrix.service.role.RoleService;

import javax.annotation.Resource;

/**
 * Created by guoyao on 2017/11/19.
 */

@RestController
public class RoleController {

    @Autowired
    private RoleService roleService ;

    @RequestMapping("testApi")
    public Object testApi() {
        return roleService.getAllStudent();
    }
}
