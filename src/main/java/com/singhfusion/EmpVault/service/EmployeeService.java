package com.singhfusion.EmpVault.service;

import com.singhfusion.EmpVault.entity.Employee;

import java.util.List;

public interface EmployeeService {
    public List<Employee> findAll();
    Employee findById(int theId);
    Employee save(Employee emp);
    void deleteById(int theId);
}
