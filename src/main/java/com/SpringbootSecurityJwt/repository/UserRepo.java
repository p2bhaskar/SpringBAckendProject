package com.SpringbootSecurityJwt.repository;

import com.SpringbootSecurityJwt.domain.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<AppUser, Long>
{
    AppUser findByUsername(String username);

}
