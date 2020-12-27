package com.graphql.springboot.graphql.resolvers.mutation;

import com.graphql.springboot.da.entity.User;
import com.graphql.springboot.graphql.inputs.UserInput;
import com.graphql.springboot.service.IUserService;
import graphql.kickstart.tools.GraphQLMutationResolver;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UserMutation implements GraphQLMutationResolver {
    private final IUserService userService;

    public User createUser(UserInput input) {
        return userService.createUser(input);
    }
}
