package com.graphql.springboot.graphql.resolvers.mutation;

import com.graphql.springboot.da.entity.Role;
import com.graphql.springboot.graphql.inputs.RoleInput;
import com.graphql.springboot.service.IRoleService;
import graphql.kickstart.tools.GraphQLMutationResolver;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class RoleMutation implements GraphQLMutationResolver {
    private final IRoleService role;

    public Role createRole(RoleInput input) throws Exception {
        return role.createRole(input);
    }
}
