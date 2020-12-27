package com.graphql.springboot.graphql.inputs;

import lombok.Data;

@Data
public class RoleInput {
    private Long id;
    private String name;
    private Long userId;
    private UserInput user;
}
