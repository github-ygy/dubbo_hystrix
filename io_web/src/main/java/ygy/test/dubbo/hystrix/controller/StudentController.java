package ygy.test.dubbo.hystrix.controller;

import com.alibaba.fastjson.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ygy.test.dubbo.hystrix.service.role.BarService;
import ygy.test.dubbo.hystrix.service.role.StudentService;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by guoyao on 2017/11/23.
 */
@RestController
public class StudentController {

    private static final Logger log=LoggerFactory.getLogger(StudentController.class);

    @Autowired
    private StudentService studentService;

    @Autowired
    private BarService barService;

    @RequestMapping("/findByid")
    public Object findByid(@RequestParam Integer id) {
        return studentService.findById(id);
    }

    @RequestMapping("/testbar")
    public Object testbar(@RequestParam String name) {
        return barService.selectByName(name);
    }

    @RequestMapping("/testThreads")
    public Object testThreads(@RequestParam String name) {
        ExecutorService executorService=Executors.newFixedThreadPool(15);
        AtomicInteger atomicInteger=new AtomicInteger(0);
        for (int i=0; i < 15; i++) {
            executorService.execute(
                    () -> {
                        log.warn("---------------- consumer "+JSONObject.toJSONString(barService.selectByName(name + atomicInteger.incrementAndGet())));
                    }
            );
        }
        executorService.shutdown();
        return barService.selectByName(name);
    }
}
