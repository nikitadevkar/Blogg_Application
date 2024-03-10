package com.bikkadIT.blog.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bikkadIT.blog.entity.Role;

public interface RoleRepo  extends JpaRepository<Role, Integer>{

}
