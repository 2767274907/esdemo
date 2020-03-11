package com.lmf.esdemo.usertest;

import com.lmf.esdemo.entity.User;
import com.lmf.esdemo.mapper.UserMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserTest {

    @Resource
    UserMapper userMapper;

    @Test
    public void test1(){
        List<User> list = userMapper.getAll();
        list.forEach(i-> System.out.println(i.getUsrName()));
    }

}
