package ygy.test.dubbo.hystrix.service.role.impl;

import com.google.common.collect.Lists;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import ygy.test.dubbo.hystrix.dto.StudentDto;
import ygy.test.dubbo.hystrix.service.role.RoleService;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

/**
 * Created by guoyao on 2017/11/19.
 */
@Service("roleService")
@com.alibaba.dubbo.config.annotation.Service(version = "1.0.0")
public class RoleServiceImpl implements RoleService {

    private static final Logger log=LoggerFactory.getLogger(RoleServiceImpl.class);

    String modul="db_service";

    private static final AtomicLong ATOMIC_LONG=new AtomicLong(0);

    private static final AtomicInteger atomicInteger=new AtomicInteger(0);

    @Override
    public List<StudentDto> getAllStudent()  {
        log.info(" getAllStudent invoke " + modul);
        List<StudentDto> sLists=Lists.newArrayList();
        StudentDto studentDto=new StudentDto();
        studentDto.setName("test");
        studentDto.setAge(atomicInteger.incrementAndGet());
        studentDto.setSex(1);
        sLists.add(studentDto);
        try {
            Thread.sleep(1000);
        } catch (Exception e) {

        }
        log.warn(" -----------------------count = " + ATOMIC_LONG.incrementAndGet());
        return sLists;
    }
    @Override
    public List<StudentDto> getAllStudentByParam(Integer i)  {
        log.info(" getAllStudent invoke " + modul);
        List<StudentDto> sLists=Lists.newArrayList();
        StudentDto studentDto=new StudentDto();
        studentDto.setName("test"+i);
        studentDto.setAge(atomicInteger.incrementAndGet());
        studentDto.setSex(1);
        sLists.add(studentDto);
        log.warn(" -----------------------count = " + i);
        return sLists;
    }


}
