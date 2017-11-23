package ygy.test.dubbo.hystrix.service;

import com.google.common.collect.Lists;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ygy.test.dubbo.hystrix.dto.StudentDto;
import ygy.test.dubbo.hystrix.service.role.BarService;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by guoyao on 2017/11/23.
 */
public class BarServiceBar implements BarService {
    private static final Logger log=LoggerFactory.getLogger(BarServiceBar.class);

    private static final AtomicInteger ATOMIC_INTEGER=new AtomicInteger(0);


    @Override
    public List<StudentDto> selectByName(String name) {
        //计算降级次数
        log.info(" - -- -- - - - - - rpc exception  mock :  " + name );
        log.warn(" ================= bar count " + ATOMIC_INTEGER.incrementAndGet());

        StudentDto studentDto=new StudentDto();
        studentDto.setName(" is mock ");
        studentDto.setSex(1);
        studentDto.setAge(1);
        return Lists.newArrayList(studentDto);
    }
}
