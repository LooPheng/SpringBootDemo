package com.example.demo.controller;

import com.example.demo.domain.User;
import com.example.demo.domain.Result;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.UserService;
import com.example.demo.utils.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
public class UserController {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserService userService;

    @GetMapping("/getPerson")
    public List<User> personEntityList() {
        return userRepository.findAll();
    }

    @GetMapping("/getOnePerson/{id}")
    public Optional<User> findOnePerson(@PathVariable("id") Integer id) {
        return userRepository.findById(id);
    }

    @GetMapping("/getPersonByAge/{age}")
    public List<User> findPersonByAge(@PathVariable("age") Integer age){
        return userRepository.findByAge(age);
    }

    @PostMapping("/addPerson")
    public Result<User> addPerson(@Valid User person, BindingResult bindingResult){

        if (bindingResult.hasErrors()){
            return ResultUtil.error(1, bindingResult.getFieldError().getDefaultMessage());
        }else {
            return ResultUtil.success(userRepository.save(person));
        }
    }

    @PostMapping("/addTwoPerson")
    public String addTwoPerson(){
        userService.insertTwo();
        return "成功！";
    }

    @PutMapping("/updatePerson/{id}")
    public User updatePerson(@PathVariable("id") Integer id,
                             @RequestParam("age") Integer age,
                             @RequestParam("sex") String sex){
        User person = new User();
        person.setSex("女");
        person.setAge(20);
        return userRepository.save(person);
    }

    @GetMapping("/getPersonAndJugeAge/{id}")
    public void getPersonAndJugeAge(@PathVariable("id") Integer id) throws Exception{
        userService.getAge(id);
    }

}
