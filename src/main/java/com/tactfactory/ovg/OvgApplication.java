package com.tactfactory.ovg;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.tactfactory.ovg.fixtures.FixtureService;

@SpringBootApplication
@EnableWebMvc
public class OvgApplication implements CommandLineRunner {

    /** The logger. */
    private static final Logger log = LoggerFactory.getLogger(OvgApplication.class);

    @Autowired(required = false)
    private FixtureService fixtures;

    /** Entry point. */
    public static void main(String[] args) {
        log.debug("Run my application");
        SpringApplication.run(OvgApplication.class, args);
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
