package ygy.test.dubbo.hystrix.notify;

import com.alibaba.fastjson.JSONObject;
import ygy.test.dubbo.hystrix.dto.StudentDto;

/**
 * Created by guoyao on 2017/11/22.
 */
public class RoleNotify  {

    public void onreturn(StudentDto studentDto,Object... args) {   //args 参数
        System.out.println("   studentDto = " + JSONObject.toJSONString(studentDto));
        System.out.println(args[0]);
    }

    public void onthrow(Throwable ex) {
        System.out.println(" error " + ex);
    }
}
