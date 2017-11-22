package ygy.test.dubbo.hystrix.service.role.impl;

import org.springframework.stereotype.Service;
import ygy.test.dubbo.hystrix.dto.StudentDto;
import ygy.test.dubbo.hystrix.service.role.StudentService;

/**
 * Created by guoyao on 2017/11/23.
 */
@Service("studentService")
public class StudentServiceImpl implements StudentService {

    @Override
    public StudentDto findById(Integer id) {
        StudentDto studentDto=new StudentDto();
        studentDto.setAge(25);
        studentDto.setName("ygy" + id);
        studentDto.setSex(1);
        return studentDto;
    }
}
