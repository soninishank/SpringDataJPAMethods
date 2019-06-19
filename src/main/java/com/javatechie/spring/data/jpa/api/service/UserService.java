package com.javatechie.spring.data.jpa.api.service;

import com.javatechie.spring.data.jpa.api.dao.UserRepository;
import com.javatechie.spring.data.jpa.api.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class UserService {

    // Inject Repository in your service
    @Autowired
    private UserRepository userRepository;


    // Creating a list of users
    @PostConstruct // It will persist the data to the database
    public void initDB() {
        List<User> users = new ArrayList<>();
        users.add(new User(111, "x", "IT", 23));
        users.add(new User(675, "y", "IT", 24));
        users.add(new User(432, "z", "CIVIL", 26));
        users.add(new User(88, "p", "IT", 23));
        users.add(new User(765, "q", "GOVT", 20));

        userRepository.saveAll(users);
    }

    public List<User> getUsers() {
        return userRepository.findAll();
    }


    public List<User> getUserByProfession(String profession) {
        return userRepository.findByProfession(profession);
    }


    public long getCounts(int age) {
        return userRepository.countByAge(age);
    }

    public List<User> deleteUser(String name) {
        return userRepository.deleteByName(name);
    }


    public List<User> findByMultiCondition(String profession, int age) {
        return userRepository.findByProfessionAndAge(profession, age);
    }

    public List<User> getUsersIgnoreCase(String profession) {
        return userRepository.findByProfessionIgnoreCase(profession);
    }


    //Sort by id, profession
    public List<User> getUserSort(String field) {
        return userRepository.findAll(new Sort(field));
    }


    // Pagination
    public Page<User> getPaginatedUser() {
        return userRepository.findAll(new PageRequest(0, 3));
    }



    public List<User> getCustomQuery()
    {
        return userRepository.getUsersCustomQuery();
    }
}
