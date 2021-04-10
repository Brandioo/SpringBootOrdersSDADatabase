package com.sda.orders.orders.repository;
import com.sda.orders.orders.model.Department;
import com.sda.orders.orders.model.Student;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface DepartmentRepository extends CrudRepository<Department, Integer> {
    List<Department> findByDepartmentName(String text);
//    List<Student> findByID(Integer text);
}
