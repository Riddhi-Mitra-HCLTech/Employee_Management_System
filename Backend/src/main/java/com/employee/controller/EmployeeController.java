package com.employee.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.employee.dto.EmployeeDTO;
import com.employee.service.EmployeeService;

import jakarta.persistence.EntityNotFoundException;

@RestController
@RequestMapping("/employee")
@CrossOrigin("*")
public class EmployeeController {

	@Autowired
	private EmployeeService service;
	
	
	@PostMapping("/register")
	public ResponseEntity<EmployeeDTO> registerNewEmployee(@RequestBody EmployeeDTO employeeDto) {
		return new ResponseEntity<EmployeeDTO>(service.registerNewEmployee(employeeDto),HttpStatus.CREATED);
	}
	
	
	@GetMapping("/getAll")
	public ResponseEntity<List<EmployeeDTO>> getAllEmployees() {
		return new ResponseEntity<List<EmployeeDTO>>(service.getAllEmployees(),HttpStatus.OK);
	}
	
	
	@DeleteMapping("/delete/{employeeId}")
	public ResponseEntity<?> deleteEmployee(@PathVariable Long employeeId) {
		try {
			service.deleteEmployee(employeeId);
			return new ResponseEntity<>("Employee with ID: "+employeeId+" has been deleted successfully",HttpStatus.OK);
		}
		catch (EntityNotFoundException e) {
			return new ResponseEntity<>(e.getMessage(),HttpStatus.NOT_FOUND);
		}
	}
	
	
	@GetMapping("/get/{employeeId}")
	public ResponseEntity<EmployeeDTO> getEmployeeById(@PathVariable Long employeeId) {
		EmployeeDTO searchedEmployeeDto = service.getEmployeeById(employeeId);
		
		return (searchedEmployeeDto == null)?
				new ResponseEntity<>(HttpStatus.NOT_FOUND)
				:new ResponseEntity<EmployeeDTO>(searchedEmployeeDto,HttpStatus.OK);
	}
	
	
	@PutMapping("/update/{employeeId}")
	public ResponseEntity<?> updateEmployeeById(@PathVariable Long employeeId, @RequestBody EmployeeDTO employeeDto) {
		try {
			EmployeeDTO updatedEmployee = service.updateEmployeeById(employeeId, employeeDto);
			return new ResponseEntity<>(updatedEmployee,HttpStatus.OK);
		}
		catch (EntityNotFoundException e) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}
}
