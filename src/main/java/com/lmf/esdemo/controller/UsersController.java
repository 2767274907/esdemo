package com.lmf.esdemo.controller;

import com.lmf.esdemo.dao.UsersRepository;
import com.lmf.esdemo.entity.Users;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

@RestController
@Slf4j
public class UsersController {

    @Autowired
    UsersRepository usersRepository;

    @GetMapping("/test01")
    public String test01(String id,String username){
        usersRepository.save(new Users(id,username));
        return id+"-----"+username;
    }

    @GetMapping("/test02")
    public Object test02(String id){
        Optional<Users> resu = usersRepository.findById(id);
        Users users = resu.get();
        return users;
    }

    @GetMapping("/test03")
    public Object test03(){
        Iterable<Users> result = usersRepository.findAll();
        Iterator<Users> resu = result.iterator();
        List<Users> list = new ArrayList<>();
        while(resu.hasNext()){
            list.add(resu.next());
        }
        return list;
    }

    @GetMapping("/test04")
    public Object test04(String id){
        usersRepository.deleteById(id);
        return "删除成功：id="+id;
    }

    @GetMapping("/test05")
    public void test05(){
        usersRepository.deleteAll();
    }


}
