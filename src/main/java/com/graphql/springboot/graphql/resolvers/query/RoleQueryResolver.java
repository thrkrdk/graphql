package com.graphql.springboot.graphql.resolvers.query;

import com.graphql.springboot.da.entity.Role;
import com.graphql.springboot.service.IRoleService;
import graphql.kickstart.tools.GraphQLQueryResolver;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class RoleQueryResolver implements GraphQLQueryResolver {
    private final IRoleService roleService;

    public Role roleById(Long id) {
        return roleService.roleById(id);
    }

    public List<Role> allRoles() {
        return roleService.allRoles();
    }
}
