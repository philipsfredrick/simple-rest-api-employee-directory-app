package com.nonso.employeedirapp.controller;

import com.nonso.employeedirapp.dto.ApiResponse;
import com.nonso.employeedirapp.dto.EmployeeDto;
import com.nonso.employeedirapp.entity.Employee;
import com.nonso.employeedirapp.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class EmployeeController {

    private final EmployeeService employeeService;

    // add an employee
    @PostMapping("/employees")
    public ResponseEntity<ApiResponse> addEmployee(@RequestBody EmployeeDto employeeDto) {
        Employee employee = employeeService.addEmployee(employeeDto);
       return new ResponseEntity<>(new ApiResponse("Employee added", true, employee), HttpStatus.CREATED);
    }

    @GetMapping("/employees")
    public ResponseEntity<ApiResponse> getAllEmployees() {
        List<Employee> employees = employeeService.getAllEmployees();
        return new ResponseEntity<>(new ApiResponse("Employees retrieved", true, employees), HttpStatus.OK);
    }

    @GetMapping("/employees/{employeeId}")
    public ResponseEntity<ApiResponse> getAnEmployee(@PathVariable("employeeId") Long employeeId) {
        Employee employee = employeeService.getEmployeeById(employeeId);
        return new ResponseEntity<>(new ApiResponse("Employee retrieved", true, employee), HttpStatus.OK);
    }

    @PutMapping("/employees/{employeeId}")
    public ResponseEntity<ApiResponse> updateEmployee(@PathVariable("employeeId") Long employeeId, @RequestBody EmployeeDto employeeDto) {
        Employee employee = employeeService.updateEmployee(employeeId, employeeDto);
        return new ResponseEntity<>(new ApiResponse("Employee updated", true, employee), HttpStatus.OK);
    }

    @DeleteMapping("/employees/{employeeId}")
    public ResponseEntity<ApiResponse> deleteEmployee(@PathVariable("employeeId") Long employeeId) {
        employeeService.deleteEmployee(employeeId);
        return new ResponseEntity<>(new ApiResponse("Employee deleted", true, null), HttpStatus.OK);
    }
}
