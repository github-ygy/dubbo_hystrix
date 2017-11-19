package ygy.test.dubbo.hystrix.service.role.impl;

import com.google.common.collect.Lists;
import org.springframework.stereotype.Service;
import ygy.test.dubbo.hystrix.dto.StudentDto;
import ygy.test.dubbo.hystrix.service.role.RoleService;

import java.util.List;

/**
 * Created by guoyao on 2017/11/19.
 */
@Service("roleService")
public class RoleServiceImpl implements RoleService {

    @Override
    public List<StudentDto> getAllStudent() {
        List<StudentDto> sLists=Lists.newArrayList();
        StudentDto studentDto=new StudentDto();
        studentDto.setName("ygy");
        studentDto.setAge(25);
        studentDto.setSex(1);
        sLists.add(studentDto);
        return sLists;
    }
}
