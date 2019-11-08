package com.tactfactory.dbexample.jdbc.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tactfactory.dbexample.jdbc.entities.User;
import com.tactfactory.dbexample.jdbc.repositories.UserRepository;

@RestController
@RequestMapping("user")
public class UserController extends CrudController<User, UserRepository> {
}
