package com.sda.orders.orders.repository;
import com.sda.orders.orders.model.Student;
import com.sda.orders.orders.model.Users;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface UserRepository extends CrudRepository<Users, Integer> {
    List<Users> findByusername(String text);

    @Query("SELECT u FROM Users u WHERE u.username = :username")
    public Users getUserByUsername(@Param("username") String username);
//    List<Student> findByID(Integer text);
}
