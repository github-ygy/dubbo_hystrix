package ygy.test.dubbo.hystrix.service.role;

import ygy.test.dubbo.hystrix.dto.StudentDto;

/**
 * Created by guoyao on 2017/11/23.
 */
public interface StudentService {

    StudentDto findById(Integer id);
}
