package com.example.demo.users;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;



import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    private final UserRepository ur;
   

    @Autowired
    public UserService(UserRepository ur) {
        this.ur = ur;
        
    }
    public int getUser(String email){
        return this.ur.findUserIdByEmail(email) ; 
    }

    public String saveUser(User user) {
        ur.save(user);
        return "User saved succesfully";
    }

   

    public List<User> getUsers() {
        return ur.findAll();
    }

    public Optional<User> getUserById(int id) {
        Optional<User> user = this.ur.findById(id);
        return  user ; 

    }

}
