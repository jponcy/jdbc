package com.tactfactory.ovg;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.tactfactory.ovg.services.fixtures.FixtureService;

@SpringBootApplication
public class OvgApplication implements CommandLineRunner {

    private static final Logger log = LoggerFactory.getLogger(OvgApplication.class);

    @Autowired(required = false)
    private FixtureService fixtures;

    public static void main(String[] args) {
        log.debug("Run my application");
        SpringApplication.run(OvgApplication.class, args);
    }

    @Bean
    public ModelMapper buildMapper() {
        return new ModelMapper();
    }

    @Override
    public void run(String... args) throws Exception {
        if (this.fixtures == null) {
            log.debug("Fixtures skipped");
        } else {
            log.debug("Fixtures loading");
            this.fixtures.load();
            log.debug("Fixtures loaded");
        }
    }
}
