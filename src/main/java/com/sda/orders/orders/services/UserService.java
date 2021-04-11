package com.sda.orders.orders.services;

import com.sda.orders.orders.model.Student;
import com.sda.orders.orders.model.Users;
import com.sda.orders.orders.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class UserService {


    @Autowired
    private UserRepository userRepository;

    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;

    public Users create(Users users) {
        users.setPassword(bCryptPasswordEncoder.encode(users.getPassword()));
        return userRepository.save(users);
    }

    public List<Users> userList() {
        return Arrays.asList(getBuild(0), getBuild(1), getBuild(2));
    }

    private Users getBuild(int i) {
        return new Users();
    }

    public Users addUser(Users users) {
        // call repository and save
        users.setPassword(bCryptPasswordEncoder.encode(users.getPassword()));
        return userRepository.save(users);
    }

    public Users updateUser(Users users) {
        return userRepository.save(users);
    }

    public void deleteUser(Integer id) {
        userRepository.deleteById(id);
    }

}
