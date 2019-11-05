package com.tactfactory.ovg.controllers;

import java.util.Collections;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Hellocontroller {

    @GetMapping("hello")
    public Map<String, String> helloAction() {
        return Collections.singletonMap("content", "Hello world!");
    }
}
