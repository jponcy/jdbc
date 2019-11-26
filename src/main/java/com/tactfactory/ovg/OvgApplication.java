package com.tactfactory.ovg;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class OvgApplication {

    private static final Logger log = LoggerFactory.getLogger(OvgApplication.class);

    public static void main(String[] args) {
        log.debug("Run my application");
        SpringApplication.run(OvgApplication.class, args);
    }

    @Bean
    public ModelMapper buildMapper() {
        return new ModelMapper();
    }
}
