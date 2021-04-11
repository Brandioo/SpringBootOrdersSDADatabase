package com.sda.orders.orders.controller;

import com.sda.orders.orders.model.Student;
import com.sda.orders.orders.repository.StudentRepository;
import com.sda.orders.orders.services.StudentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController
public class HelloWorldController {

    private final StudentService studentService;


    private static Logger LOG = LoggerFactory
            .getLogger(HelloWorldController.class);

    public HelloWorldController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("students")
    public ResponseEntity<List<Student>> getStudent() {

        return new ResponseEntity<List<Student>>(studentService.studentList(),
                HttpStatus.CREATED);

    }

    @PostMapping("student")
    public ResponseEntity<Student> addStudent(@RequestBody Student student) {
        return new ResponseEntity<Student>(studentService.addStudent(student),
                HttpStatus.CREATED);

    }

    @Autowired
    StudentRepository studentRepository;

    @GetMapping(value = "/all")
    public List<Student> searchAll() {
        List<Student> usersList = new ArrayList<>();
        Iterable<Student> userses = studentRepository.findAll();
        userses.forEach(usersList::add);
        return usersList;
    }

    @Autowired
    StudentRepository usersRepository;

    @GetMapping(value = "/name/{text}")
    public List<Student> searchName(@PathVariable final String text) {
        return usersRepository.findByName(text);
    }

//    @GetMapping(value = "/id/{id}")
//    public List<Student> findByID(@PathVariable final Integer id) {
//        return usersRepository.findByID(id);
//    }

    @GetMapping("student/{email}")
    /*
     * Krijoni nje metode ne studentService E cila merr te dhena nga application.properties dhe gjen studentin by Email
     * Perdorni Student si endpoint
     * */
    public Integer getMessagge(@RequestParam Integer number1, @RequestParam Integer number2) {
        return number1 + number2;
    }

    @PutMapping("students")
    public ResponseEntity<Student> updateStudent(@Valid @RequestBody Student student) {
        return new ResponseEntity<Student>(studentService.updateStudent(student),
                HttpStatus.OK);
    }

    @DeleteMapping("students/{id}")
    public ResponseEntity<String> deleteStudent(@PathVariable Integer id) {
        studentService.deleteStudent(id);
        return new ResponseEntity<String>(HttpStatus.OK);
    }

    @GetMapping("studentDepartment/{dep}")
    public List<Student> getStudentbyDep(@PathVariable String dep) {
        return studentService.getStudentsByDep(dep);
    }



    /*
     * Krijoni nje Medote te re POST e cila krijon nje student dhe kthen listen e studenteve qe ndodhen ne sistem
     * Pra krijo nje student dhe kthe nje array me sudentet qe ndodhen ne Properties file
     * Perdorni Student si endpoint
     * */

}
