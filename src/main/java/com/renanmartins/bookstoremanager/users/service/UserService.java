package com.renanmartins.bookstoremanager.users.service;

import com.renanmartins.bookstoremanager.users.dto.MessageDTO;
import com.renanmartins.bookstoremanager.users.dto.UserDTO;
import com.renanmartins.bookstoremanager.users.entity.User;
import com.renanmartins.bookstoremanager.users.exception.UserAlreadyExistsException;
import com.renanmartins.bookstoremanager.users.exception.UserNotFoundException;
import com.renanmartins.bookstoremanager.users.mapper.UserMapper;
import com.renanmartins.bookstoremanager.users.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    private final static UserMapper userMapper = UserMapper.INSTANCE;

    private UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public MessageDTO create(UserDTO userToCreateDTO) {
        verifyIfExists(userToCreateDTO.getEmail(), userToCreateDTO.getUsername());
        User userToCreate = userMapper.toModel(userToCreateDTO);
        User createdUser = userRepository.save(userToCreate);
        return creationMessage(createdUser);
    }

    public void delete(Long id){
        verifyIfExists(id);
        userRepository.deleteById(id);
    }

    private void verifyIfExists(String email, String username) {
        Optional<User> foundUser = userRepository.findByEmailOrUsername(email, username);
        if (foundUser.isPresent()) {
            throw new UserAlreadyExistsException(email, username);
        }
    }


    private MessageDTO creationMessage(User createdUser) {
        String createdUsername = createdUser.getUsername();
        Long createdId = createdUser.getId();
        String createdUserMessage = String.format("User %s with ID %s successfully created",
                createdUsername, createdId);
        return MessageDTO.builder()
                .message(createdUserMessage)
                .build();
    }

    private void verifyIfExists(Long id) {
        userRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException(id));
    }
}
