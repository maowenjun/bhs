package com.bhs.app.dao;


import com.bhs.app.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by ThinkPad on 2018/3/17.
 */
@Repository
public interface UserRepository extends MongoRepository<User,Integer> {


}
