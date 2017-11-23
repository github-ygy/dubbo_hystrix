package ygy.test.dubbo.hystrix.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ygy.test.dubbo.hystrix.service.role.BarService;
import ygy.test.dubbo.hystrix.service.role.StudentService;

/**
 * Created by guoyao on 2017/11/23.
 */
@RestController
public class StudentController {

    @Autowired
    private StudentService studentService ;

    @Autowired
    private BarService barService ;

    @RequestMapping("/findByid")
    public Object findByid(@RequestParam Integer id) {
       return studentService.findById(id);
    }
    @RequestMapping("/testbar")
    public Object testbar(@RequestParam String name) {
       return barService.selectByName(name);
    }
}
