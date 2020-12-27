package com.graphql.springboot.service;

import com.graphql.springboot.da.entity.Role;
import com.graphql.springboot.graphql.inputs.RoleInput;

import java.util.List;
import java.util.Set;

public interface IRoleService {

    List<Role> roleByUserId(Long id);

    List<Role> findByUser_IdIn(Set<Long> id);

    List<Role> allRoles();

    Role createRole(RoleInput input);

    Role roleById(Long id);
}
