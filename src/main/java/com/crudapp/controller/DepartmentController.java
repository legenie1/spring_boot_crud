package com.crudapp.controller;

import com.crudapp.service.DepartmentService;
import com.crudapp.entity.Department;
import com.crudapp.error.DepartmentNotFoundException;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DepartmentController {

        @Autowired
        private DepartmentService departmentService;

        private final Logger LOGGER = LoggerFactory.getLogger(DepartmentController.class);

        @GetMapping("/departments")
        public List<Department> fetchDepartmentList(){
                LOGGER.info("Inside fetchDepartmentList of Department Controller");
                return (List<Department>) departmentService.fetchDepartmentList();
        }

        @PostMapping("/departments")
        public Department saveDepartment(@Valid @RequestBody Department department){
                LOGGER.info("Inside save department of Department Controller");
                return departmentService.saveDepartment(department);
        }

        @GetMapping("/departments/{id}")
        public Department fetchDepartmentById(@PathVariable("id") Long departmentId) throws DepartmentNotFoundException {
                return departmentService.fetchDepartmentById(departmentId);
        }

        @DeleteMapping("/departments/{id}")
        public String deleteDepartmentById(@PathVariable("id") Long deparmentId){
                departmentService.deleteDepartmentById(deparmentId);
                return "Department deleted Successfully";
        }

        @PutMapping("/departments/{id}")
        public Department updateDepartment(@PathVariable("id") Long departmentId, @RequestBody Department department){
                return departmentService.updateDepartment(departmentId, department);
        }

        @GetMapping("/departments/name/{name}")
        public Department fetchDepartmentByName(@PathVariable("name") String departmentName){
                return departmentService.fetchDepartmentByName(departmentName);
        }

}
