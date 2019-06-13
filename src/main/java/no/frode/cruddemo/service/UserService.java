package no.frode.cruddemo.service;

import no.frode.cruddemo.entity.Product;
import no.frode.cruddemo.entity.User;
import no.frode.cruddemo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
}
