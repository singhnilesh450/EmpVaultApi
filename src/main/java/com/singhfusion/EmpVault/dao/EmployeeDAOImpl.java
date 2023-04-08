package com.singhfusion.EmpVault.dao;

import com.singhfusion.EmpVault.entity.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeeDAOImpl implements EmployeeDAO{

    private EntityManager entityManager;

    @Autowired
    public EmployeeDAOImpl(EntityManager entityManager){
        this.entityManager=entityManager;
    }
    @Override
    public List<Employee> findAll() {
        TypedQuery<Employee> query=entityManager.createQuery("from Employee",Employee.class);
        List<Employee> emp=query.getResultList();
        return emp;
    }

    @Override
    public Employee findById(int theId) {
        Employee emp=entityManager.find(Employee.class,theId);
        return emp;
    }

    @Override
    public Employee save(Employee emp) {
        Employee savedEmp=entityManager.merge(emp);
        return savedEmp;
    }

    @Override
    public void deleteById(int theId) {
        Employee emp=entityManager.find(Employee.class,theId);
        entityManager.remove(emp);
    }
}
