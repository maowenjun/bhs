package com.bhs.app.web;


import com.bhs.app.dao.UserRepository;
import com.bhs.app.model.User;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


/**
 * Created by ThinkPad on 2018/3/17.
 */
@RestController
public class BootStartController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private MongoTemplate mongoTemplate;

    @RequestMapping(value = "/hello",method = RequestMethod.GET)
    public Object hello(){
        User user = new User();
        user.setId(12345);
        user.setName("测试人");
        //userRepository.insert(user);
        Query query = new Query();
        query.addCriteria(Criteria.where("name").is("测试人"));
        List<User> userList =  mongoTemplate.find(query,User.class);
        return userList;
    }



}
