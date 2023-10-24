package com.example.employees.DAO;

import com.example.employees.entity.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeeDAOimp implements EmployeeDAO {
    private EntityManager entityManager;

    @Autowired
    public EmployeeDAOimp(EntityManager entityManager){
        this.entityManager = entityManager;
    }

    @Override
    public List<Employee> findAll() {
        TypedQuery<Employee> typedQuery = entityManager.createQuery("from Employee", Employee.class);
        List<Employee> list = typedQuery.getResultList();
        return list;
    }

    @Override
    public Employee findById(int id) {
        return entityManager.find(Employee.class, id);
    }

    @Override
    public Employee save(Employee employee) {
        return entityManager.merge(employee);
    }

    @Override
    public String deleteById(int id) {
        entityManager.remove(findById(id));
        return "Employee with Id " + id +" is deleted";
    }
}