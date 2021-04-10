package com.sda.orders.orders.controller;

import com.sda.orders.orders.model.Department;
import com.sda.orders.orders.repository.DepartmentRepository;
import com.sda.orders.orders.services.DepartmentService;
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
public class DepartmentController {

    private final DepartmentService departmentService;


    private static Logger LOG = LoggerFactory
            .getLogger(HelloWorldController.class);

    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @GetMapping("departments")
    public ResponseEntity<List<Department>> getDepartments() {

        return new ResponseEntity<List<Department>>(departmentService.departmentList(),
                HttpStatus.CREATED);

    }

    @PostMapping("department")
    public ResponseEntity<Department> addDepartment(@RequestBody Department department) {
        return new ResponseEntity<Department>(departmentService.addDepartment(department),
                HttpStatus.CREATED);

    }

    @Autowired
    DepartmentRepository departmentRepository;

    @GetMapping(value = "/allDepartments")
    public List<Department> searchAllDepartments() {
        List<Department> usersList = new ArrayList<>();
        Iterable<Department> userses = departmentRepository.findAll();
        userses.forEach(usersList::add);
        return usersList;
    }


    @GetMapping(value = "/departmentName/{text}")
    public List<Department> searchDepartmentName(@PathVariable final String text) {
        return departmentRepository.findByDepartmentName(text);
    }

//    @GetMapping(value = "/id/{id}")
//    public List<Student> findByID(@PathVariable final Integer id) {
//        return usersRepository.findByID(id);
//    }

    @GetMapping("department/{description}")
    /*
     * Krijoni nje metode ne studentService E cila merr te dhena nga application.properties dhe gjen studentin by Email
     * Perdorni Student si endpoint
     * */
    public Integer getMesaggeDepartment(@RequestParam Integer number1, @RequestParam Integer number2) {
        return number1 + number2;
    }

    @PutMapping("departments")
    public ResponseEntity<Department> updateDepartment(@Valid @RequestBody Department department) {
        return new ResponseEntity<Department>(departmentService.updateDepartment(department),
                HttpStatus.OK);
    }

    @DeleteMapping("departments/{id}")
    public ResponseEntity<String> deleteDepartment(@PathVariable Integer id) {
        departmentService.deleteDepartment(id);
        return new ResponseEntity<String>(HttpStatus.OK);
    }



    /*
     * Krijoni nje Medote te re POST e cila krijon nje student dhe kthen listen e studenteve qe ndodhen ne sistem
     * Pra krijo nje student dhe kthe nje array me sudentet qe ndodhen ne Properties file
     * Perdorni Student si endpoint
     * */

}
