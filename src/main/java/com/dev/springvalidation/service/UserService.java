package com.dev.springvalidation.service;

import com.dev.springvalidation.dto.UserDTO;
import com.dev.springvalidation.entity.User;
import com.dev.springvalidation.exception.UserNotFoundException;
import com.dev.springvalidation.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User save(UserDTO userDTO){
        User user = User.build(0, userDTO.getName(), userDTO.getEmail(), userDTO.getMobile(), userDTO.getGender(), userDTO.getAge(), userDTO.getNationality());
        return userRepository.save(user);
    }

    public List<User> fetchAllUser(){
        return userRepository.findAll();
    }

    public User getUser(int userId) throws UserNotFoundException {
        User user = userRepository.findByUserId(userId);
        if(user != null){
            return user;
        }else{
            throw new UserNotFoundException("User Not Found!");
        }
    }
}
