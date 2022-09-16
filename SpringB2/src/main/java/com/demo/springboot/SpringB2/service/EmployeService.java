package com.demo.springboot.SpringB2.service;


import com.demo.springboot.SpringB2.model.Employee;
import com.demo.springboot.SpringB2.model.EmployeeDTO;

import java.util.List;

public interface EmployeService {

    public Employee saveEmployee(Employee employee);

    public List<EmployeeDTO> getAllEmployee();

    public Boolean deleteEmployee(Long empId);

    public EmployeeDTO getEmployee(Long empId);

    public Boolean updateEmployee(Long empId, EmployeeDTO employeeDTO);

    public List<EmployeeDTO> getByName();


}