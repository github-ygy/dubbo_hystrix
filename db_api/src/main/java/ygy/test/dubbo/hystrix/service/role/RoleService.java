package ygy.test.dubbo.hystrix.service.role;

import ygy.test.dubbo.hystrix.dto.StudentDto;

import java.util.List;

/**
 * Created by guoyao on 2017/11/19.
 */
public interface RoleService {

    public List<StudentDto> getAllStudent();

    public List<StudentDto> getAllStudentByParam(Integer i);
}
