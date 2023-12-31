package com.example.activitimock;


import org.activiti.engine.IdentityService;
import org.activiti.engine.identity.Group;
import org.activiti.engine.identity.User;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;


@SpringBootApplication(scanBasePackages = {"org.activiti"})
public class ActivitiMockApplication {

	public static void main(String[] args) {
		SpringApplication.run(ActivitiMockApplication.class, args);
	}

	@Bean
	InitializingBean usersAndGroupsInitializer(final IdentityService identityService) {
		return new InitializingBean() {
			public void afterPropertiesSet() throws Exception {

				Group group = identityService.newGroup("user");
				group.setName("users");
				group.setType("security-role");
				identityService.saveGroup(group);

				User admin = identityService.newUser("admin");
				admin.setPassword("admin");
				identityService.saveUser(admin);

			}
		};
	}
}
