package com.hamzacicek.todoapplication;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

// Prevent Login Page
@SpringBootApplication(exclude = {
        //SecurityAutoConfiguration.class,
        org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration.class,
        org.springframework.boot.actuate.autoconfigure.security.servlet.ManagementWebSecurityAutoConfiguration.class
}
)
public class TodoapplicationApplication {

	public static void main(String[] args) {
		SpringApplication.run(TodoapplicationApplication.class, args);
	}

}
