package ygy.test.dubbo.hystrix.service.role;

import ygy.test.dubbo.hystrix.dto.StudentDto;

import java.util.List;

/**
 * Created by guoyao on 2017/11/23.
 */
public interface BarService {

    List<StudentDto> selectByName(String name);
}
