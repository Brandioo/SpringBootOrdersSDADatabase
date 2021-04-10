package com.sda.orders.orders.services;

import com.sda.orders.orders.config.PropertyConfiguration;
import com.sda.orders.orders.model.Student;
import com.sda.orders.orders.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class StudentService {

    private final PropertyConfiguration propertyConfiguration;
    @Autowired
    private StudentRepository studentRepository;

    public StudentService(PropertyConfiguration propertyConfiguration
    ) {
        this.propertyConfiguration = propertyConfiguration;

    }

    public List<Student> studentList() {
        return Arrays.asList(getBuild(0), getBuild(1), getBuild(2));
    }

    private Student getBuild(int i) {
        return new Student();
    }

    public Student addStudent(Student student) {
        // call repository and save
        return studentRepository.save(student);
    }

    public Student updateStudent(Student student) {
        return studentRepository.save(student);
    }

    public void deleteStudent(Integer id) {
        studentRepository.deleteById(id);
    }
}
