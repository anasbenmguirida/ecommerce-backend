package com.example.demo.users;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class UserService {
    private final UserRepository ur;

    @Autowired
    public UserService(UserRepository ur) {
        this.ur = ur;
    }

    public String saveUser(User user) {
        ur.save(user);
        return "User saved succesfully";
    }

    public List<User> getUsers() {
        return ur.findAll();
    }

}
