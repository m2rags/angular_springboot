package com.demo.springboot.SpringB2.serviceImp;

import com.demo.springboot.SpringB2.model.Address;
import com.demo.springboot.SpringB2.model.Employee;
import com.demo.springboot.SpringB2.model.EmployeeDTO;
import com.demo.springboot.SpringB2.repository.EmployeeRepository;
import com.demo.springboot.SpringB2.service.EmployeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeService {
    @Autowired
    EmployeeRepository employeeRepository;

    @Override
    public Employee saveEmployee(Employee employee) {


        Employee employee1 = new Employee(employee.getFirstName(), employee.getLastName(), employee.getEmailId());

        //creating address
       /*Address address1=new Address();
        List<Address> ls=employee.getAddress();
        for(Address ob:ls){
            Address address=ob;
            address1.setStreet1(address.getStreet1());
            address1.setStreet2(address.getStreet2());
            address1.setCity(address.getCity());
            address1.setCountry(address.getCountry());
            address1.setPinCode(address.getPinCode());
        }
        address1.setEmployee(employee1);

     //adding in the address
        employee1.getAddress().add(address1);*/
        Address address1 = new Address();
        List<Address> ls = employee.getAddress();
        for (Address ob : ls) {
            Address address = ob;
            address1.setStreet1(address.getStreet1());
            address1.setStreet2(address.getStreet2());
            address1.setCity(address.getCity());
            address1.setCountry(address.getCountry());
            address1.setPinCode(address.getPinCode());
            address1.setEmployee(employee1);
        }

        //Address address1=new Address("m road","s v road","bangalore","india",new Long(56460));


        employee1.setAddress(Arrays.asList(address1));

        Employee employee2 = employeeRepository.save(employee1);
        return employee2;
    }

    @Override
    public List<EmployeeDTO> getAllEmployee() {

        List<EmployeeDTO> lsEmp = new ArrayList<EmployeeDTO>();
        List<Employee> ls = employeeRepository.findEmployee();
        for (Employee employee : ls) {
            EmployeeDTO employeeDTO = new EmployeeDTO();
            employeeDTO.setId(employee.getId());
            employeeDTO.setFirstName(employee.getFirstName());
            employeeDTO.setLastName(employee.getLastName());
            employeeDTO.setEmailId(employee.getEmailId());
            lsEmp.add(employeeDTO);
        }

        return lsEmp;
    }

    @Override
    public Boolean deleteEmployee(Long empId) {

        employeeRepository.deleteById(empId);
        return true;
    }

    @Override
    public EmployeeDTO getEmployee(Long empId) {

        Optional<Employee> optional = employeeRepository.findById(empId);

        EmployeeDTO employeeDTO = new EmployeeDTO();
        optional.ifPresent(employee -> {
            System.out.println("User's firstName = " + employee.getId());
            employeeDTO.setId(employee.getId());
            employeeDTO.setFirstName(employee.getFirstName());
            employeeDTO.setLastName(employee.getLastName());
            employeeDTO.setEmailId(employee.getEmailId());

        });


        return employeeDTO;
    }

    @Override
    public Boolean updateEmployee(Long empId, EmployeeDTO employeeDTO) {
        Employee employee = new Employee();
        employee.setId(empId);
        employee.setFirstName(employeeDTO.getFirstName());
        employee.setLastName(employeeDTO.getLastName());
        employee.setEmailId(employeeDTO.getEmailId());
        employeeRepository.save(employee);
        return true;
    }

    @Override
    public List<EmployeeDTO> getByName() {

        List<Employee> optional= employeeRepository.findAll();


        return null;
    }


}
