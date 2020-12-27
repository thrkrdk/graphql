package com.graphql.springboot.da.repository;

import com.graphql.springboot.da.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
    List<Role> findByUser_Id(Long id);

    List<Role> findByUser_IdIn(Set<Long> ids);
}
