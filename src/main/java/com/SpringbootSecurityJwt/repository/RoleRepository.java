package com.SpringbootSecurityJwt.repository;

import com.SpringbootSecurityJwt.domain.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role ,Long>
{
    Role findByName(String name);
}
