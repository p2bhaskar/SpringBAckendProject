package com.SpringbootSecurityJwt;

import com.SpringbootSecurityJwt.domain.AppUser;
import com.SpringbootSecurityJwt.domain.Role;
import com.SpringbootSecurityJwt.service.AppUserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;

@SpringBootApplication
public class SpringbootSecurityJwtApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootSecurityJwtApplication.class, args);
	}

  @Bean
	CommandLineRunner run(AppUserService userService){
		return args->{
			userService.saveRole(new Role(null,"ROLE_USER"));
			userService.saveRole(new Role(null,"ROLE_MANAGER"));
			userService.saveRole(new Role(null,"ROLE_ADMIN"));
			userService.saveRole(new Role(null,"ROLE_SUPER_ADMIN"));

			userService.saveUser(new AppUser(null,"John Travolta","john","1234",new ArrayList<>()));
			userService.saveUser(new AppUser(null,"Will Smith","will","1234",new ArrayList<>()));
			userService.saveUser(new AppUser(null,"Jim carey","jim","1234",new ArrayList<>()));
			userService.saveUser(new AppUser(null,"Arnold Schwarzenegger","arnold","1234",new ArrayList<>()));
			userService.saveUser(new AppUser(null,"Brad Pitt","brad","1234",new ArrayList<>()));

			userService.addRoleToUser("john","ROLE_USER");
			userService.addRoleToUser("john","ROLE_MANAGER");
			userService.addRoleToUser("will","ROLE_USER");
			userService.addRoleToUser("jim","ROLE_ADMIN");
			userService.addRoleToUser("arnold","ROLE_SUPER_ADMIN");
			userService.addRoleToUser("arnold","ROLE_USER");
			userService.addRoleToUser("brad","ROLE_MANAGER");






		};


	}
}
