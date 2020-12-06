package com.th.employee.repository;
import org.springframework.data.repository.CrudRepository;

import com.th.employee.model.Employee;
public interface EmployeeRepository extends CrudRepository<Employee, Integer>
{
}
