package com.demo.springboot.SpringB2.controller;

import com.demo.springboot.SpringB2.model.Employee;
import com.demo.springboot.SpringB2.model.EmployeeDTO;
import com.demo.springboot.SpringB2.service.EmployeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.*;




@RestController
@CrossOrigin("http://localhost:8080")
@RequestMapping("/v2/api")
public class NewController {

    @Autowired
    EmployeService employeService;
    @PostMapping("/save")
    public Employee createEmployee(@Valid @RequestBody Employee employee){

        Employee emp1=employeService.saveEmployee(employee);
        System.out.println("Helloo");
        return emp1;
    }
    @GetMapping("/dummy")
    public List<EmployeeDTO>  getByName(){
        return employeService.getByName();

    }

    @GetMapping("/retrive")
    public List<EmployeeDTO> getAllEmployeesList(){
        return employeService.getAllEmployee();
    }

    @DeleteMapping("/delete/{id}")
    public Map<String, Boolean> deleteEmployee(@PathVariable(value = "id") Long id){
        Boolean flag=employeService.deleteEmployee(id);
        Map<String, Boolean> reponse=new HashMap<>();
        reponse.put("Deleted", Boolean.TRUE);
        return reponse;
            }

       @GetMapping("/Retrive/{id}")
    public EmployeeDTO getEmployee(@PathVariable(value="id")Long empId){
       EmployeeDTO employeeDTO =  employeService.getEmployee(empId);
         return employeeDTO;

    }
     @DeleteMapping("scrap/{id}")
    public Map<String, Boolean> deleteEmployee1(@PathVariable(value = "id") Long empId) {
        Boolean flag=employeService.deleteEmployee(empId);
        Map<String, Boolean> response= new HashMap<>();
        response.put("Deleted", Boolean.TRUE);
        return response;
    }







}
