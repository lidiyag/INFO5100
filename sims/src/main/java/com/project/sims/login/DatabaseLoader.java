package com.project.sims.login;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class DatabaseLoader {
    private UserRepository repo;

    public DatabaseLoader(UserRepository repo) {
        this.repo = repo;
    }

    @Bean
    public CommandLineRunner initializeDatabase() {
        return args -> {
            // adds 2 users to the app
            User user1 = new User("admin@gmail.com", "admin", Role.ADMIN);
            User user2 = new User("ramesh@gmail.com", "student", Role.STUDENT);

            repo.saveAll(List.of(user1, user2));

            System.out.println("User Database initialized");
        };
    }

}
