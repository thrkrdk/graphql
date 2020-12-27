package com.graphql.springboot.graphql.resolvers;

import com.graphql.springboot.da.entity.Role;
import com.graphql.springboot.da.entity.User;
import com.graphql.springboot.service.IRoleService;
import graphql.kickstart.tools.GraphQLResolver;
import graphql.schema.DataFetchingEnvironment;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.dataloader.DataLoader;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Random;
import java.util.concurrent.CompletableFuture;

@Component
@RequiredArgsConstructor
@Slf4j
public class UserResolver implements GraphQLResolver<User> {
    private final IRoleService roleService;

    public List<Role> roles(User user) {
        return roleService.roleByUserId(user.getId());
    }

    public String firstName(User user) {
        log.info("Kişinin adının sonuna rasgele numara eklendi");
        return user.getFirstName().concat(String.valueOf((new Random()).nextInt(10)));
    }

    public CompletableFuture<List<Role>> roles2(User user, DataFetchingEnvironment dfe) {
        final DataLoader<Long, List<Role>> dataloader = dfe.getDataLoaderRegistry()
                .getDataLoader("userRoleDataLoader");

        return dataloader.load(user.getId());
    }
}
