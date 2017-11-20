package ygy.test.dubbo.hystrix.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * Created by guoyao on 2017/11/19.
 */

@Data
public class StudentDto  implements Serializable{


    private String name ;

    private Integer age ;

    private Integer sex ;

}
