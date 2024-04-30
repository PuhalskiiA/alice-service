package com.example.aliceservice.skill.services.userService;

import com.example.aliceservice.skill.exceptions.UserNotFoundException;
import com.example.aliceservice.skill.model.entityes.User;
import com.example.aliceservice.skill.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserRepository userRepository;

    @Override
    public User getUserById(UUID id) {
        Optional<User> userOpt = Optional.ofNullable(userRepository.getUserById(id));

        if (userOpt.isPresent()) {
            return userOpt.get();
        } else {
            throw new UserNotFoundException("User not found");
        }
    }

    @Override
    public void addUser(UUID id, String name, String surname, String email, String sex, String psuid) {
        userRepository.addUser(id, name, surname, email, sex, psuid);
    }

    @Override
    public UUID getIdByPsuid(String psuid) {
        return userRepository.getIdByPsuid(psuid);
    }

    @Override
    public Optional<User> getUserByPsuid(String psuid) {
        return Optional.ofNullable(userRepository.getUserByPsuid(psuid));
    }
}
