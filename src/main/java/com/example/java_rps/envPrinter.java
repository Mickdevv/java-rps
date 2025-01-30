package com.example.java_rps; // Make sure the package matches your project structure

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class envPrinter implements CommandLineRunner {

    @Value("${spring.datasource.url}")
    private String dbUrl;

    @Value("${spring.datasource.username}")
    private String dbUser;

    @Value("${spring.datasource.password}")
    private String dbPassword;

    @Override
    public void run(String... args) {
        System.out.println("\n=========== Loaded Application Properties ===========");
        System.out.println("Database URL     : " + dbUrl);
        System.out.println("Database User    : " + dbUser);
        System.out.println("Database Password: " + dbPassword);
        System.out.println("=====================================================\n");
    }
}
