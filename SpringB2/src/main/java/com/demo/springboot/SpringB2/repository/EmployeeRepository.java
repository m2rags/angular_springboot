package com.demo.springboot.SpringB2.repository;


import com.demo.springboot.SpringB2.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Long> {
    @Query(value = "SELECT emp FROM Employee emp")
    public List<Employee> findEmployee();

}
