package com.employee.employee_management.service.impl;

import com.employee.employee_management.dto.EmployeeDTO;
import com.employee.employee_management.entity.Employee;
import com.employee.employee_management.exception.ResourceNotFoundException;
import com.employee.employee_management.mapper.EmployeeMapper;
import com.employee.employee_management.repository.EmployeeRepository;
import com.employee.employee_management.service.EmployeeService;
import lombok.AllArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class EmployeeServiceImpl implements EmployeeService {

    EmployeeRepository employeeRepository;
    @Override
    public EmployeeDTO createEmployee(EmployeeDTO e)
    {
        Employee EmployeeEnity = EmployeeMapper.mapIntoEmployeeEntity(e);
        Employee savedEmployee = employeeRepository.save(EmployeeEnity);
        return EmployeeMapper.mapIntoEmployeeDTO(savedEmployee);
    }

    @Override
    public EmployeeDTO getEmployeeById(Long Id) {
        //If the value is present in the Optional it will return otherwise it throws the error.
        Employee emp = null;
        try {
            emp = employeeRepository.findById(Id).orElseThrow(()->new ResourceNotFoundException("Not Found In DB"));
        } catch (ResourceNotFoundException e) {
            throw new RuntimeException(e.getMessage());
        }
        return EmployeeMapper.mapIntoEmployeeDTO(emp);
    }

    @Override
    public List<EmployeeDTO> getAllEmployee() {
        List<Employee> employees  = employeeRepository.findAll();
        //it replaces the lambda with Method Reference
        List<EmployeeDTO> emp = employees.stream().map(EmployeeMapper::mapIntoEmployeeDTO).toList();
        return emp;
    }

    @SneakyThrows
    @Override
    public EmployeeDTO updateEmployee(Long Id, EmployeeDTO employeeDTO) {
        Employee employee = employeeRepository.findById(Id).orElseThrow(()-> new ResourceNotFoundException("Not Found In DB"));
        employee.setId(Id);
        employee.setFirstName(employeeDTO.getFirstName());
        employee.setLastName(employeeDTO.getLastName());
        employee.setEmail(employeeDTO.getEmail());
        Employee savedEmp = employeeRepository.save(employee);

        return EmployeeMapper.mapIntoEmployeeDTO(savedEmp);
    }

    @Override
    @SneakyThrows
    public void deleteEmployee(Long Id) {
        Employee employee = employeeRepository.findById(Id).orElseThrow(()-> new ResourceNotFoundException("Not Found In DB"));
        employeeRepository.deleteById(Id);
    }
}
