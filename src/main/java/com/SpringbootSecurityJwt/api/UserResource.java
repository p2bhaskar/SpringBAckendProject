package com.SpringbootSecurityJwt.api;

import com.SpringbootSecurityJwt.domain.AppUser;
import com.SpringbootSecurityJwt.domain.Role;
import com.SpringbootSecurityJwt.service.AppUserService;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;


@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class UserResource
{
    private final AppUserService userService;

    @GetMapping("/users")
    public ResponseEntity<List<AppUser>> getUsers(){
        return ResponseEntity.ok().body(userService.getUsers());
    }

    @PostMapping("/user/save")
    public ResponseEntity<AppUser> saveUser(
            @RequestBody AppUser user
    ){
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/api/user/save").toUriString());
        return ResponseEntity.created(uri).body(userService.saveUser(user));
    }

    @PostMapping("/role/save")
    public ResponseEntity<Role> saveRole(
            @RequestBody Role role
    ){
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/api/role/save").toUriString());
        return ResponseEntity.created(uri).body(userService.saveRole(role));
    }

    @PostMapping("/role/addtouser")
    public ResponseEntity<?> addRoleToUser(@RequestBody RoleToUserForm form){

        userService.addRoleToUser(form.getUserName(),form.getRoleName());
        return ResponseEntity.ok().build();
    }



}
@Data
class RoleToUserForm
{
    private String userName;

    private String roleName;
}
