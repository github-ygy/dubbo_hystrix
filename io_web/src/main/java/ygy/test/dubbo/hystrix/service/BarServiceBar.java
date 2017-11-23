package ygy.test.dubbo.hystrix.service;

import com.google.common.collect.Lists;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ygy.test.dubbo.hystrix.dto.StudentDto;
import ygy.test.dubbo.hystrix.service.role.BarService;

import java.util.List;

/**
 * Created by guoyao on 2017/11/23.
 */
public class BarServiceBar implements BarService {
    private static final Logger log=LoggerFactory.getLogger(BarServiceBar.class);


    @Override
    public List<StudentDto> selectByName(String name) {

        log.info(" - -- -- - - - - - rpc exception  mock :  " + name);

        StudentDto studentDto=new StudentDto();
        studentDto.setName(" is mock ");
        studentDto.setSex(1);
        studentDto.setAge(1);
        return Lists.newArrayList(studentDto);
    }
}
