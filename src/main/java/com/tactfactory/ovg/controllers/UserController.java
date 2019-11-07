package com.tactfactory.ovg.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tactfactory.ovg.entities.User;
import com.tactfactory.ovg.repositories.UserRepository;

@RestController
@RequestMapping("user")
public class UserController extends CrudController<User, UserRepository> {

}
