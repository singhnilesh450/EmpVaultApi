package com.singhfusion.EmpVault.rest;


import com.singhfusion.EmpVault.entity.Employee;
import com.singhfusion.EmpVault.service.EmployeeService;
import org.springframework.beans.factory.parsing.EmptyReaderEventListener;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {
    private EmployeeService employeeService;

    public EmployeeRestController(EmployeeService theEmployeeService){
        employeeService=theEmployeeService;
    }
    @GetMapping("/employees")
    public List<Employee> findAll(){
        return employeeService.findAll();
    }

    @GetMapping("/employees/{employeeId}")
    public  Employee getEmployeeById(@PathVariable int employeeId){
        Employee emp=employeeService.findById(employeeId);
        if(emp==null){
            throw new RuntimeException("Employee Id not found - " + employeeId);
        }
        return emp;
    }
    @PostMapping("/employees")
    public Employee addEmployee(@RequestBody Employee theEmployee){
        theEmployee.setId(0);
        Employee dbEmployee=employeeService.save(theEmployee);
        return dbEmployee;
    }
    @PutMapping("/employees")
    public Employee updateEmployee(@RequestBody Employee theEmployee){
        Employee dbEmployee=employeeService.save(theEmployee);
        return dbEmployee;
    }
    @DeleteMapping("/employees/{employeeId}")
    public String deleteEmployee(@PathVariable int employeeId){
        Employee emp=employeeService.findById(employeeId);
        if(emp==null){
            throw new RuntimeException("Employee Id NOT FOUND - " + employeeId);
        }
        employeeService.deleteById(employeeId);
        return "Employee with emplooye id - " +employeeId+" deleted successdully";
    }

}
