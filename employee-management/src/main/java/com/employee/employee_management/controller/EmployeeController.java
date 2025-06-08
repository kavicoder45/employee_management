package com.employee.employee_management.controller;



import com.employee.employee_management.dto.EmployeeDTO;
import com.employee.employee_management.service.EmployeeService;
import lombok.AllArgsConstructor;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/employees")
@AllArgsConstructor
public class EmployeeController {

   private EmployeeService employeeService;


   //Build REST API to Add Employee
   @PostMapping
   public ResponseEntity<EmployeeDTO> createEmployee(@RequestBody EmployeeDTO employeeDTO)
   {
       EmployeeDTO savedEmployee = employeeService.createEmployee(employeeDTO);
       return new ResponseEntity<>(savedEmployee, HttpStatus.CREATED);
   }
   //Build REST API to Get Employee
    @GetMapping("{id}")
    public ResponseEntity<EmployeeDTO> getEmployeeById(@PathVariable("id") Long empId)
    {
        EmployeeDTO emp = employeeService.getEmployeeById(empId);
        return new ResponseEntity<>(emp,HttpStatus.ACCEPTED);
    }
    //Build REST API to Get Empoyees
    @GetMapping
    public ResponseEntity<List<EmployeeDTO>> getAllEmployee()
    {
       List<EmployeeDTO> employees =  employeeService.getAllEmployee();
       return ResponseEntity.ok(employees);
    }

    @PutMapping("{id}")
    public ResponseEntity<EmployeeDTO> updateEmployee(@PathVariable("id") Long Id,
                                                      @RequestBody EmployeeDTO employeeDTO)
    {
        EmployeeDTO emp = employeeService.updateEmployee(Id,employeeDTO);
        return ResponseEntity.ok(emp);
    }
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteEmployeeById(@PathVariable("id") Long Id)
    {
        employeeService.deleteEmployee(Id);
        return ResponseEntity.ok("The Employee Deleted SuccessFully");
    }
}
