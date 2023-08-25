package com.example.studentservice.controller;

import com.example.studentservice.model.Employee;
import com.example.studentservice.repository.EmployeeRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    private EmployeeRepository employeeRepository;
    private static final Logger LOGGER = LoggerFactory.getLogger(EmployeeController.class);

    public EmployeeController(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @PostMapping
    public Employee add(@RequestBody Employee employee){
        LOGGER.info("EmployeeController:add:Employee: {}", employee);
        return employeeRepository.add(employee);
    }

    @GetMapping
    public List<Employee> all(){
        LOGGER.info("EmployeeController:all");
        return employeeRepository.all();
    }

    @GetMapping("/{id}")
    public Employee get(@PathVariable Long id){
        LOGGER.info("EmployeeController:get:id: {}", id);
        return employeeRepository.get(id);
    }

    @GetMapping("/department/{id}")
    public List<Employee> getByDepartmentId(@PathVariable Long id){
        LOGGER.info("EmployeeController:getByDepartmentId:id: {}", id);
        return employeeRepository.findByDepartmentId(id);
    }
}
