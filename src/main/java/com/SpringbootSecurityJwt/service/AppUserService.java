package com.SpringbootSecurityJwt.service;

import com.SpringbootSecurityJwt.domain.AppUser;
import com.SpringbootSecurityJwt.domain.Role;

import java.util.List;

public interface AppUserService
{
    AppUser saveUser(AppUser user);
    Role saveRole (Role role);
    void addRoleToUser(String userName,String roleName);
    AppUser getUser(String userName);
    List<AppUser> getUsers();

}
