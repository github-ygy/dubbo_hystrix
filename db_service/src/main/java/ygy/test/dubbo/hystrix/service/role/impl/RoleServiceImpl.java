package ygy.test.dubbo.hystrix.service.role.impl;

import com.google.common.collect.Lists;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import ygy.test.dubbo.hystrix.dto.StudentDto;
import ygy.test.dubbo.hystrix.service.role.RoleService;

import java.util.List;

/**
 * Created by guoyao on 2017/11/19.
 */
@Service("roleService")
@com.alibaba.dubbo.config.annotation.Service(version = "1.0.0")
public class RoleServiceImpl implements RoleService {

    private static final Logger log=LoggerFactory.getLogger(RoleServiceImpl.class);

    String modul="db_service";

    @Override
    public List<StudentDto> getAllStudent()  {
        log.info(" getAllStudent invoke " + modul);
        List<StudentDto> sLists=Lists.newArrayList();
        StudentDto studentDto=new StudentDto();
        studentDto.setName("test");
        studentDto.setAge(25);
        studentDto.setSex(1);
        sLists.add(studentDto);
        try {
            Thread.sleep(5000);
        } catch (Exception e) {

        }

        return sLists;
    }
}
