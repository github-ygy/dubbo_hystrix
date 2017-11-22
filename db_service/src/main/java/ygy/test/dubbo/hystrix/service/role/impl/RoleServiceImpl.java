package ygy.test.dubbo.hystrix.service.role.impl;

import com.google.common.collect.Lists;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import ygy.test.dubbo.hystrix.dto.StudentDto;
import ygy.test.dubbo.hystrix.listener.RoleCallbackListener;
import ygy.test.dubbo.hystrix.service.role.RoleService;

import javax.annotation.PostConstruct;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

/**
 * Created by guoyao on 2017/11/19.
 */
@Service("roleService")
//@com.alibaba.dubbo.config.annotation.Service(version="1.0.0")
public class RoleServiceImpl implements RoleService {

    private final Map<String, RoleCallbackListener> listeners=new ConcurrentHashMap<String, RoleCallbackListener>();

    @PostConstruct
    public void init() {
        //Thread t=new Thread(new Runnable() {
        //    public void run() {
        //        while (true) {
        //            try {
        //                for (Map.Entry<String, RoleCallbackListener> entry : listeners.entrySet()) {
        //                    try {
        //                        entry.getValue().changed(getChanged(entry.getKey()));
        //                    } catch (Throwable t) {
        //                        listeners.remove(entry.getKey());
        //                    }
        //                }
        //                Thread.sleep(5000); // 定时触发变更通知
        //            } catch (Throwable t) { // 防御容错
        //                t.printStackTrace();
        //            }
        //        }
        //    }
        //});
        //t.setDaemon(true);
        //t.start();
    }

    public void addListener(String key, RoleCallbackListener listener) {
        listeners.put(key, listener);
        listener.changed(getChanged(key)); // 发送变更通知
    }

    private String getChanged(String key) {

        return "Changed: " + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());

    }

    private static final Logger log=LoggerFactory.getLogger(RoleServiceImpl.class);

    String modul="db_service";

    private static final AtomicLong ATOMIC_LONG=new AtomicLong(0);

    private static final AtomicInteger atomicInteger=new AtomicInteger(0);

    @Override
    public List<StudentDto> getAllStudent() {
        log.info(" getAllStudent invoke " + modul);
        List<StudentDto> sLists=Lists.newArrayList();
        StudentDto studentDto=new StudentDto();
        studentDto.setName("test");
        studentDto.setAge(atomicInteger.incrementAndGet());
        studentDto.setSex(1);
        sLists.add(studentDto);
        //try {
        //    Thread.sleep(1000);
        //} catch (Exception e) {
        //
        //}
        log.warn(" -----------------------count = " + ATOMIC_LONG.incrementAndGet());
        return sLists;
    }

    @Override
    public List<StudentDto> getAllStudentByParam(Integer i) {
        log.info(" getAllStudent invoke " + modul);
        List<StudentDto> sLists=Lists.newArrayList();
        StudentDto studentDto=new StudentDto();
        studentDto.setName("test" + i);
        studentDto.setAge(atomicInteger.incrementAndGet());
        studentDto.setSex(1);
        sLists.add(studentDto);
        log.warn(" -----------------------count = " + i);
        return sLists;
    }


    @Override
    public StudentDto getByIdAsyc(Integer id) {
        log.info(" getByIdAsyc id = " + id);
        StudentDto studentDto=new StudentDto();
        studentDto.setName("test" + id);
        studentDto.setAge(atomicInteger.incrementAndGet());
        studentDto.setSex(1);
        try {
            Thread.sleep(3000);   //睡眠三秒，测试异步
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return studentDto;
    }
}
