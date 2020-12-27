
package com.graphql.springboot.service.impl;

import com.graphql.springboot.da.entity.Role;
import com.graphql.springboot.da.entity.User;
import com.graphql.springboot.da.repository.UserRepository;
import com.graphql.springboot.graphql.inputs.UserInput;
import com.graphql.springboot.service.IUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service @Transactional
@RequiredArgsConstructor
public class UserService implements IUserService {

    private final UserRepository userRepository;


    @Override
    public User findByEmail(String email) {
        return userRepository.findByEmail(email).orElse(null);
    }

    @Override
    public List<User> allUser() {
        return userRepository.findAll();
    }

    @Override
    public User createUser(UserInput input) {
        User user = User.builder()
                .id(input.getId())
                .email(input.getEmail())
                .firstName(input.getFirstName())
                .lastName(input.getLastName())
                .build();
        return userRepository.save(user);
    }
}
