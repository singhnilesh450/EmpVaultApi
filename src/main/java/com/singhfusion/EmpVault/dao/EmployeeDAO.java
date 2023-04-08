package com.singhfusion.EmpVault.dao;

import com.singhfusion.EmpVault.entity.Employee;

import java.util.List;

public interface EmployeeDAO {

     List<Employee> findAll();
     Employee findById(int theId);
     Employee save(Employee emp);
     void deleteById(int theId);
}
