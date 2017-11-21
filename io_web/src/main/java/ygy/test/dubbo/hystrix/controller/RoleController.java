package ygy.test.dubbo.hystrix.controller;

import com.alibaba.fastjson.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ygy.test.dubbo.hystrix.dto.StudentDto;
import ygy.test.dubbo.hystrix.service.role.RoleService;

import java.util.List;

/**
 * Created by guoyao on 2017/11/20.
 */
@RestController
public class RoleController {
    private static final Logger log=LoggerFactory.getLogger(RoleController.class);


    //@Reference(version = "1.0.0")   //开启dubbo注解是使用
    @Autowired
    private RoleService roleService ;   //使用xml 配置时，可用autowired注入

    @RequestMapping("testConsumer")
    public Object testConsumer() {
        return roleService.getAllStudent();
    }

    @RequestMapping("testCache")
    public Object testCache() {
        log.warn(JSONObject.toJSONString(roleService.getAllStudent(0)));
        for(int i = 0;i<5;i++) {
            log.info("------------------"+ JSONObject.toJSONString(roleService.getAllStudent(0)));
        }
        System.out.println("===========================================================================");
        for(int i = 0;i < 1001;i++) {  //执行1001次
            log.info("------------------"+ JSONObject.toJSONString(roleService.getAllStudent(i)));
        }
        return roleService.getAllStudent(0);  //lru 会移除第一个缓存
    }

}
