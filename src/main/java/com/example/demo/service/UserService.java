package com.example.demo.service;

import com.example.demo.domain.User;
import com.example.demo.enums.ResultEnum;
import com.example.demo.exception.PersonException;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Description:
 * @Auther: LF
 * @Date: 2018/7/4 22:44
 */
@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    @Transactional
    public void insertTwo(){
        User person1 = new User();
        person1.setAge(25);
        person1.setSex("男");
        User person2 = new User();
        person2.setSex("女");
        person2.setAge(18);

        userRepository.save(person1);
        userRepository.save(person2);
    }


    public void getAge(Integer id) throws Exception {
        List<User> personList = userRepository.findAll();
        Integer age = 0;
        for (User p : personList
             ) {
            if (p.getId() == id){
                age = p.getAge();
                break;
            }
        }

        if (age < 10){
            throw new PersonException(age, "你还在上小学吧！");
        }else if (age > 10 && age < 16){
            throw new PersonException(age, "你还在上中学吧！");
        }else {
            throw new PersonException(ResultEnum.UNIVERSITY);
        }
    }

}
