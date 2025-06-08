package com.employee.employee_management.service;

import com.employee.employee_management.dto.EmployeeDTO;

import java.util.List;

public interface EmployeeService {

    public EmployeeDTO createEmployee(EmployeeDTO employeeDTO);
    public EmployeeDTO getEmployeeById(Long Id);
    public List<EmployeeDTO> getAllEmployee();
    public EmployeeDTO updateEmployee(Long Id, EmployeeDTO employeeDTO);
    public void deleteEmployee(Long Id);
}

