package com.employee.employee_management.mapper;

import com.employee.employee_management.dto.EmployeeDTO;
import com.employee.employee_management.entity.Employee;

public class EmployeeMapper {

    public static Employee mapIntoEmployeeEntity(EmployeeDTO e)
    {
        return new Employee(
                e.getId(),
                e.getFirstName(),
                e.getLastName(),
                e.getEmail()
        );
    }

    public static EmployeeDTO mapIntoEmployeeDTO(Employee e)
    {
        return new EmployeeDTO(
                e.getId(),
                e.getFirstName(),
                e.getLastName(),
                e.getEmail()
        );
    }
}
