package com.graphql.springboot.graphql.inputs;

import lombok.Data;

import java.util.List;

@Data
public class UserInput {
    private Long id;
    private String email;
    private String firstName;
    private String lastName;
    private List<RoleInput> roles;
}
