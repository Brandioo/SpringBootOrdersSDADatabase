package com.sda.orders.orders.services;

import com.sda.orders.orders.config.PropertyConfiguration;
import com.sda.orders.orders.model.Department;
import com.sda.orders.orders.model.Student;
import com.sda.orders.orders.repository.DepartmentRepository;
import com.sda.orders.orders.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class DepartmentService {

    private final PropertyConfiguration propertyConfiguration;
    @Autowired
    private DepartmentRepository departmentRepository;

    public DepartmentService(PropertyConfiguration propertyConfiguration
    ) {
        this.propertyConfiguration = propertyConfiguration;

    }

    public List<Department> departmentList() {
        return Arrays.asList(getBuild(0), getBuild(1), getBuild(2));
    }

    private Department getBuild(int i) {
        return new Department();
    }

    public Department addDepartment(Department department) {
        // call repository and save
        return departmentRepository.save(department);
    }

    public Department updateDepartment(Department department) {
        return departmentRepository.save(department);
    }

    public void deleteDepartment(Integer id) {
        departmentRepository.deleteById(id);
    }
}
