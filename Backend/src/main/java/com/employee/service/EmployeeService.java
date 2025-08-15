package com.employee.service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employee.dto.EmployeeDTO;
import com.employee.entity.Employee;
import com.employee.repository.EmployeeRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class EmployeeService {

	@Autowired
	private EmployeeRepository repository;
	
	public EmployeeDTO registerNewEmployee(EmployeeDTO employeeDto) {
		Employee newEmployee = Employee.builder()
				.name(employeeDto.name())
				.email(employeeDto.email())
				.phone(employeeDto.phone())
				.department(employeeDto.department())
				.build();
		
		repository.save(newEmployee);
		
		return new EmployeeDTO(
				newEmployee.getId(),
				newEmployee.getName(),
				newEmployee.getEmail(),
				newEmployee.getPhone(),
				newEmployee.getDepartment());
	}
	
	
	public List<EmployeeDTO> getAllEmployees() {
		List<Employee> employeeList = repository.findAll();
		
		return employeeList
		.stream()
		.sorted(Comparator.comparing(e -> e.getId()))
		.map(e -> new EmployeeDTO(
				e.getId(),
				e.getName(),
				e.getEmail(),
				e.getPhone(),
				e.getDepartment()))
		.collect(Collectors.toList());
		
	}
	
	
	public void deleteEmployee(Long Id) {
		if(!repository.existsById(Id)) {
			throw new EntityNotFoundException("Could not find Employee");
		}
		
		repository.deleteById(Id);
	}
	
	
	public EmployeeDTO getEmployeeById(Long Id) {
		Employee searchedEmployee = repository.findById(Id).orElse(null);
		
		return new EmployeeDTO(
				searchedEmployee.getId(),
				searchedEmployee.getName(),
				searchedEmployee.getEmail(),
				searchedEmployee.getPhone(),
				searchedEmployee.getDepartment());
	}
	
	
	public EmployeeDTO updateEmployeeById(Long Id, EmployeeDTO employeeDto) {
		Employee existingEmployee = repository.findById(Id).orElse(null);
		
		if(existingEmployee != null) {
			existingEmployee.setName(employeeDto.name());
			existingEmployee.setEmail(employeeDto.email());
			existingEmployee.setPhone(employeeDto.phone());
			existingEmployee.setDepartment(employeeDto.department());
		}
			
		repository.save(existingEmployee);
			
		return new EmployeeDTO(
					existingEmployee.getId(),
					existingEmployee.getName(),
					existingEmployee.getEmail(),
					existingEmployee.getPhone(),
					existingEmployee.getDepartment());
	}
	
}
