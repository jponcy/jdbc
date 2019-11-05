package com.tactfactory.ovg;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.tactfactory.ovg.repositories.UserRepository;

@SpringBootApplication
public class OvgApplication implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    public static void main(String[] args) {
        SpringApplication.run(OvgApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
//        this.userRepository.selectAll(connection);
    }

}
