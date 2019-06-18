package com.pgdca.lms.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pgdca.lms.model.Role;
public interface RoleRepository extends JpaRepository<Role, Long>{

	Role findRoleByName(String roleName);


}
