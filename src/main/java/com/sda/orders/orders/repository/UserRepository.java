package com.sda.orders.orders.repository;
import com.sda.orders.orders.model.Student;
import com.sda.orders.orders.model.Users;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface UserRepository extends CrudRepository<Users, Integer> {
    List<Users> findByusername(String text);

//    List<Student> findByID(Integer text);
}
