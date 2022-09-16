package com.demo.springboot.SpringB2.controller;

import com.demo.springboot.SpringB2.model.Employee;
import com.demo.springboot.SpringB2.model.EmployeeDTO;
import com.demo.springboot.SpringB2.service.EmployeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin(origins="http://localhost:8080")
@RequestMapping("/api/v1")
public class EmployeeController {

    @Autowired
    EmployeService employeService;

    @PostMapping("/employees")
    public Employee createEmployee(@Valid @RequestBody Employee employee){

       Employee employee1=employeService.saveEmployee(employee);

       System.out.println("helooooooooooooooooooooo");
       return employee1;
    }

    @GetMapping("/employees")
    public List<EmployeeDTO> getEmployeesList(){

          return  employeService.getAllEmployee();

    }

    @DeleteMapping("/employees/{id}")
    public Map<String,Boolean> deleteEmployee(@PathVariable(value = "id") Long empId){

        Boolean flag= employeService.deleteEmployee(empId);
        Map<String,Boolean> response=new HashMap<String,Boolean>();
        response.put("Deleted",Boolean.TRUE);

        return response;
    }

    @GetMapping("/employees/employee/{id}")
    public EmployeeDTO getEmployee(@PathVariable(value="id")Long empId){

        EmployeeDTO employeeDTO=employeService.getEmployee(empId);
        return employeeDTO;
    }


    @PutMapping("/employees/{id}")
    public boolean updateEmployee(@PathVariable(value="id")Long empId,@Valid @RequestBody EmployeeDTO employeeDTO ){

        return employeService.updateEmployee(empId,employeeDTO);
    }


}
