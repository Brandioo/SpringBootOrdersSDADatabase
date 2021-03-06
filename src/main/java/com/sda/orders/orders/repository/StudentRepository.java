package com.sda.orders.orders.repository;
import com.sda.orders.orders.model.Student;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface StudentRepository extends CrudRepository<Student, Integer> {

    List<Student> findByName(String text);

    List<Student> findByDepartment_departmentName(String depName);
//    List<Student> findByID(Integer text);
}
