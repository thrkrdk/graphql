
package com.graphql.springboot.service;

import com.graphql.springboot.da.entity.User;
import com.graphql.springboot.graphql.inputs.UserInput;

import java.util.List;

public interface IUserService {

    User findByEmail(String email);

    List<User> allUser();

    User createUser(UserInput input);
}
