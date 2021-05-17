package com.renanmartins.bookstoremanager.users.service;

import com.renanmartins.bookstoremanager.users.mapper.UserMapper;
import com.renanmartins.bookstoremanager.users.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final static UserMapper userMapper = UserMapper.INSTACE;

    private UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
}
