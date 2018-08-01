package com.example.demo.controller;

import com.example.demo.domain.User;
import com.example.demo.properties.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class HelloController {

    @Autowired
    private Person person;

    @RequestMapping(value = {"/hello", "/hi"}, method = RequestMethod.GET)
    public String say( Integer i) {
        // @PathVariable("id") 、@RequestParam(value="id", required=false, defaultValue="0")
        return i + "Hello Spring Boot! 年龄8：" + person.getAge() + " 性别：" + person.getSex();
    }

    @GetMapping("/getUser")
    public User getUser() {
        User user = new User();
        user.setId(88);
        user.setAge(66);
        user.setSex("男3");
        return user;
    }

}
