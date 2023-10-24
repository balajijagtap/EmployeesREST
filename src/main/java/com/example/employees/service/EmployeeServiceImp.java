package com.example.employees.service;

import com.example.employees.DAO.EmployeeRepository;
import com.example.employees.entity.Employee;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImp implements EmployeeService{

    private EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeServiceImp(EmployeeRepository employeeRepository){
        this.employeeRepository = employeeRepository;
    }

    @Override
    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

    //@Override
    public Employee findById(int id) {
        Optional<Employee> employee = employeeRepository.findById(id);
        Employee theEmployee = null;
        if(employee.isPresent()) theEmployee = employee.get();
        else{
            throw new RuntimeException("Employee with id " + id + " is not found");
        }
        return theEmployee;
    }

    @Override
    @Transactional
    public Employee save(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    @Transactional
    public String deleteById(int id) {
        employeeRepository.deleteById(id);
        return "Employee with id " + id + " is deleted";
    }
}