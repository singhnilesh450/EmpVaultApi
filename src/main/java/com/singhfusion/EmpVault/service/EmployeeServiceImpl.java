package com.singhfusion.EmpVault.service;


import com.singhfusion.EmpVault.dao.EmployeeRepository;
import com.singhfusion.EmpVault.entity.Employee;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService{

    private EmployeeRepository employeeRepository;

    public EmployeeServiceImpl(EmployeeRepository theemployeeRepository){
        employeeRepository=theemployeeRepository;
    }
    @Override
    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee findById(int theId) {

        Optional<Employee> result = employeeRepository.findById(theId);
        Employee theEmployee=null;
        if(result.isPresent()){
            theEmployee=result.get();
        }else{
            throw  new RuntimeException("Could not find the Id "+theId);
        }
        return theEmployee;
    }


    @Override
    public Employee save(Employee emp) {
        return employeeRepository.save(emp);
    }


    @Override
    public void deleteById(int theId) {
        employeeRepository.deleteById(theId);
    }
}
