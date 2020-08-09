package com.vtb.zolotarev.spring.mvc.services;

import com.vtb.zolotarev.spring.mvc.model.User;
import com.vtb.zolotarev.spring.mvc.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private UserRepository userRepository;

    @Autowired
    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void save(User user) {
        userRepository.save(user);
    }

    public User findUserById(long id) {
        return userRepository.findUserById(id);
    }

    public List<User> findAllUsers() {
        return userRepository.findAllUsers();
    }

    public void deleteUserById(long id){
        userRepository.deleteUserById(id);
    }
}
