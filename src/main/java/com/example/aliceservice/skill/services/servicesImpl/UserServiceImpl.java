package com.example.aliceservice.skill.services.servicesImpl;

import com.example.aliceservice.skill.exceptions.UserNotFoundException;
import com.example.aliceservice.skill.model.entityes.User;
import com.example.aliceservice.skill.repositories.UserRepository;
import com.example.aliceservice.skill.services.UserService;
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
}
