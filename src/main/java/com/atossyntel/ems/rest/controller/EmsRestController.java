package com.atossyntel.ems.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.ContextLoaderListener;

import com.atossyntel.ems.model.Employee;
import com.atossyntel.ems.service.EmployeeService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;


@RequestMapping("/employees")
@RestController
public class EmsRestController {


	
	
	@Qualifier("esi")
	@Autowired
	private EmployeeService employeeService;

	public EmsRestController() {
		System.out.println("######### EmsRestController created########");
	}

	@ApiOperation("return all employees")
	
	@GetMapping
	public List<Employee> getAllEmployees() {
	return employeeService.findAllEmployees();
	}
		
	@ApiOperation("return employee with specific id")
	
	@GetMapping("/{id}")
	public Employee getEmployee(@PathVariable("id")int id) {
	return employeeService.findEmployee(id);
	}
	
	@ApiOperation("delete employee with specific id")
	@DeleteMapping("/{id}")
	public List<Employee> deleteEmployee(@PathVariable("id")int id) {
		   employeeService.deleteEmployee(id);
		return employeeService.findAllEmployees();
	
	}
	
	@ApiOperation("update employee with specific id")
	@PutMapping("/{id}")
	public List<Employee> deleteEmployee(@PathVariable("id")int id,@RequestBody Employee employee) {
		  employeeService.updateEmployee(employee);
		  return employeeService.findAllEmployees();
	
	}
	
	
	
	@ApiResponses({
		@ApiResponse(code=200,message="User insertion successfull"),
		@ApiResponse(code=500,message="Problem in Server side while user insertion "),
		@ApiResponse(code=404,message="Invalid URL "),
		@ApiResponse(code=401,message="Invalid credentials"),
		@ApiResponse(code=403,message="Don't have permission for the operation"),
				
	})
	@ApiOperation("add employee with specific id")
	@PostMapping
	public List<Employee> addEmployee(@RequestBody Employee employee) {
		  employeeService.addEmployee(employee);
		  return employeeService.findAllEmployees();
	
	}
	
	
}
