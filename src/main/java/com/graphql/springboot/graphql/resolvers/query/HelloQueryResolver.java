package com.graphql.springboot.graphql.resolvers.query;

import com.graphql.springboot.da.entity.User;
import com.graphql.springboot.service.IUserService;
import graphql.kickstart.tools.GraphQLQueryResolver;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class HelloQueryResolver implements GraphQLQueryResolver {
    public String hello() {
        return "Hello....";
    }

}
