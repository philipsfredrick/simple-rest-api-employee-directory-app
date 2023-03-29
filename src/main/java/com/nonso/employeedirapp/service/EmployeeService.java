package com.nonso.employeedirapp.service;

import com.nonso.employeedirapp.dto.EmployeeDto;
import com.nonso.employeedirapp.entity.Employee;

import java.util.List;

public interface EmployeeService {

    // get all employees
    List<Employee> getAllEmployees();

    // add an employee
    Employee addEmployee(EmployeeDto employeeDto);

    // get an employee by id
    Employee getEmployeeById(Long employeeId);

    // update an employee
    Employee updateEmployee(Long employeeId, EmployeeDto employeeDto);

    // delete an employee
    void deleteEmployee(Long employeeId);

}
