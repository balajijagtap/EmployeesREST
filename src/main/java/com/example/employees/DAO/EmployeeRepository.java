package com.example.employees.DAO;

import com.example.employees.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.webmvc.RepositoryRestController;

// to change the default path of endpoint use this annotation
@RepositoryRestResource(path="employees")
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
    // using spring data jpa
}
