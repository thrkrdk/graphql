package com.graphql.springboot.service.impl;

import com.graphql.springboot.da.entity.Role;
import com.graphql.springboot.da.repository.RoleRepository;
import com.graphql.springboot.graphql.inputs.RoleInput;
import com.graphql.springboot.service.IRoleService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Set;

@Service @Transactional
@RequiredArgsConstructor  @Slf4j
public class RoleService implements IRoleService {
    private final RoleRepository roleRepository;

    @Override
    public List<Role> roleByUserId(Long id) {
        log.info("{} nolu kullanıcı için veritabanından rolleri getirildi", id);
        return roleRepository.findByUser_Id(id);
    }

    @Override
    public List<Role> findByUser_IdIn(Set<Long> ids) {
        log.info("Tüm Kullanıcıların rolleri tek seferde getirildi.");
        return roleRepository.findByUser_IdIn(ids);
    }

    @Override
    public List<Role> allRoles() {
        return roleRepository.findAll();
    }

    @Override
    public Role createRole(RoleInput input) {
        Role role = Role.builder()
                .id(input.getId())
                .name(input.getName())
                .userId(input.getUserId())
                .build();
        return roleRepository.save(role);
    }

    @Override
    public Role roleById(Long id) {
        return roleRepository.findById(id).orElse(null);
    }
}
