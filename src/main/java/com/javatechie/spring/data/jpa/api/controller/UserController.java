package com.javatechie.spring.data.jpa.api.controller;

import com.javatechie.spring.data.jpa.api.model.User;
import com.javatechie.spring.data.jpa.api.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Component
@RequestMapping("/spring-data-jpa")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/getUsers")
    public List<User> getAllUsers() {
        return userService.getUsers();
    }


    @GetMapping("/getUserByProfession/{profession}")
    public List<User> getUserByProfession(@PathVariable String profession) {
        return userService.getUserByProfession(profession);
    }

    @GetMapping("/getCountByAge/{age}")
    public String getCountByAge(@PathVariable int age) {
        long count = userService.getCounts(age);
        return "total no of records are " + count;
    }


    @DeleteMapping("/delete/{name}")
    public List<User> deleteUser(@PathVariable String name) {
        return userService.deleteUser(name);
    }


    // http://localhost:9090/spring-data-jpa/findMultiCondition/IT/23
    @GetMapping("/findMultiCondition/{profession}/{age}")
    public List<User> getUsersByProfessionAndAge(@PathVariable String profession, @PathVariable int age) {
        return userService.findByMultiCondition(profession, age);
    }


    // Using Request Param
    // http://localhost:9090/spring-data-jpa/getUsersIgnoreCase?profession=it
    //

    @GetMapping("/getUsersIgnoreCase")
    public List<User> getUsersByprofession(@RequestParam("profession") String profession) {
        return userService.getUsersIgnoreCase(profession);
    }

    //http://localhost:9090/spring-data-jpa/getSort/id
    //http://localhost:9090/spring-data-jpa/getSort/name

    @GetMapping("/getSort/{field}")
    public List<User> getSortedUsers(@PathVariable String field) {
        return userService.getUserSort(field);
    }

    // http://localhost:9090/spring-data-jpa/getPaginatedData
    @GetMapping("/getPaginatedData")
    public Page<User> getPaginatedRecords() {
        return userService.getPaginatedUser();
    }

    @GetMapping("/getRecordsByCustomQuery")
    public List<User> getUsersByCustomQuery() {
        return userService.getCustomQuery();
    }


}
