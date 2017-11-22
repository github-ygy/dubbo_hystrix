package ygy.test.dubbo.hystrix.service;

import ygy.test.dubbo.hystrix.dto.StudentDto;
import ygy.test.dubbo.hystrix.service.role.StudentService;

/**
 * Created by guoyao on 2017/11/23.
 */
public class StudentServiceStub implements StudentService {

    private final StudentService studentService;

    public StudentServiceStub(StudentService studentService) {
        this.studentService=studentService;
    }

    @Override
    public StudentDto findById(Integer id) {
        if(id < 10)
            return null;

        return studentService.findById(id);
    }
}
