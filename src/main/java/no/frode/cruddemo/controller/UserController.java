package no.frode.cruddemo.controller;

import no.frode.cruddemo.entity.Product;
import no.frode.cruddemo.entity.User;
import no.frode.cruddemo.service.ProductService;
import no.frode.cruddemo.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(name = "Users", value = "users")
public class UserController {
    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    UserService userService;

    @GetMapping(value = "/")
    List<User> getAllUsers() {
        logger.info("__getAllUsers");
        return userService.getAllUsers();
    }
}
