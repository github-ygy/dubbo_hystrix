package ygy.test.dubbo.hystrix.service;

import com.alibaba.fastjson.JSONObject;
import com.google.common.collect.Lists;
import lombok.Data;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ygy.test.dubbo.hystrix.dto.StudentDto;
import ygy.test.dubbo.hystrix.service.role.BarService;

import java.util.ArrayList;
import java.util.HashMap;
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
        log.info(" - -- -- - - - - - rpc exception  mock :  " + name);
        log.warn(" ================= bar count " + ATOMIC_INTEGER.incrementAndGet());

        StudentDto studentDto=new StudentDto();
        studentDto.setName(" is mock ");
        studentDto.setSex(1);
        studentDto.setAge(1);
        return Lists.newArrayList(studentDto);
    }


    public static void main(String[] args) {

        List<City> list=new ArrayList<>();
        list.add(new City("1", "test1", null));
        list.add(new City("2", "test2", "1"));
        list.add(new City("3", "test3", "1"));
        list.add(new City("4", "test4", "2"));
        list.add(new City("5", "test5", "3"));
        list.add(new City("6", "test6", "5"));
        list.add(new City("7", "test7", "4"));
        List resultList=new ArrayList<>();
        build(list, null, resultList);
        System.out.println(JSONObject.toJSON(resultList));
    }


    public static void build(List<City> llist, String id, List resultList) {
        for (City city : llist) {
            if (city.getPid()== id) {
                HashMap<String, Object> dataMap=new HashMap<>();
                dataMap.put("name", city.getName());
                dataMap.put("id", city.getId());
                List dataList=new ArrayList();
                dataMap.put("children", dataList);
                resultList.add(dataMap);
                build(llist, city.getId(), dataList);
            }
        }
    }
}


@Data
class City {
    private String id;
    private String name;
    private String pid;

    City(String id, String name, String pid) {
        this.id=id;
        this.name=name;
        this.pid=pid;
    }
}
