package com.example.employees.DAO;

import com.example.employees.entity.Employee;
import java.util.List;

public interface EmployeeDAO {
    List<Employee> findAll();
    Employee findById(int id);
    Employee save(Employee employee);
    String deleteById(int id);
}
