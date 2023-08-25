package com.example.studentservice.repository;

import com.example.studentservice.model.Employee;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class EmployeeRepository {
    private static List<Employee> employees = new ArrayList<>();
    public Employee add(Employee employee){
        employees.add(employee);
        return employee;
    }
    public Employee get(Long id){
        return employees.stream().filter(d->d.id().longValue()==id.longValue()).findFirst().orElseThrow(()->new RuntimeException("Employee not found"));
    }

    public List<Employee> all(){
        return employees;
    }

    public List<Employee> findByDepartmentId(Long id){
        return employees.stream().filter(d->d.departmentId().longValue()==id.longValue()).collect(Collectors.toList());
    }
}
