package ygy.test.dubbo.hystrix.service.role.impl;

import com.google.common.collect.Lists;
import org.springframework.stereotype.Service;
import ygy.test.dubbo.hystrix.dto.StudentDto;
import ygy.test.dubbo.hystrix.service.role.BarService;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by guoyao on 2017/11/23.
 */
@Service("barService")
public class BarServiceImpl implements BarService {

    @Override
    public List<StudentDto> selectByName(String name) {
        ArrayList<StudentDto> resultList=Lists.newArrayList();
        StudentDto studentDto1=new StudentDto();
        studentDto1.setAge(25);
        studentDto1.setName(name);
        studentDto1.setSex(1);
        StudentDto studentDto2=new StudentDto();
        studentDto2.setAge(20);
        studentDto2.setName(name);
        studentDto2.setSex(0);
        resultList.add(studentDto1);
        resultList.add(studentDto2);
        try {
            Thread.sleep(5000);   //模拟超时，rpc 异常，降级服务
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return resultList;
    }
}
