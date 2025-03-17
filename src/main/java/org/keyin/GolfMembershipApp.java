package org.keyin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan("org.keyin")
@EnableJpaRepositories("org.keyin")

public class GolfMembershipApp {
    public static void main(String[] args) {
        SpringApplication.run(GolfMembershipApp.class, args);
    }
}