package com.tactfactory.ovg;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class OvgApplication {

    private static final Logger log = LoggerFactory.getLogger(OvgApplication.class);

    public static void main(String[] args) {
        log.debug("Run my application");
        SpringApplication.run(OvgApplication.class, args);
    }
}
