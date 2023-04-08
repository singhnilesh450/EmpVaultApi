package com.singhfusion.EmpVault.dao;

import com.singhfusion.EmpVault.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
}
