package com.SpringbootSecurityJwt.service;

import com.SpringbootSecurityJwt.domain.AppUser;
import com.SpringbootSecurityJwt.domain.Role;
import com.SpringbootSecurityJwt.repository.RoleRepository;
import com.SpringbootSecurityJwt.repository.UserRepo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service @RequiredArgsConstructor @Transactional @Slf4j
public class AppUserServiceImpl implements AppUserService{
    private final UserRepo userRepo;

    private final RoleRepository roleRepository;

    @Override
    public AppUser saveUser(AppUser user) {

        log.info("Saving new user to the database");
        return userRepo.save(user);
    }

    @Override
    public Role saveRole(Role role) {

        log.info("Saving new role {} to the database",role.getName());
        return roleRepository.save(role);
    }

    @Override
    public void addRoleToUser(String userName, String roleName) {

        log.info("Adding role {} to user {}",roleName,userName);
              AppUser user = userRepo.findByUsername(userName);
              Role role = roleRepository.findByName(roleName);
              user.getRoles().add(role);
    }

    @Override
    public AppUser getUser(String userName) {

        log.info("Fetching user {}",userName);
        return userRepo.findByUsername(userName);
    }

    @Override
    public List<AppUser> getUsers() {

        log.info("Fetching All Users");
        return userRepo.findAll();
    }
}
