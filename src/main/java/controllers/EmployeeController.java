package controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dto.Employeedto;
import exception.EmployeeNotFound;
import repository.EmplyoeeRepository;
import services.EmployService;
import services.EmployeeServiceImpl;

import java.util.List;

@RestController
@RequestMapping("/Employee")
public class EmployeeController {
	
	@Autowired
	private EmployeeServiceImpl employeeService;
	
	@DeleteMapping("/delet/{id}")
	public void deliteByIdy(@PathVariable Long id) {
		employeeService.deliteByIdy(id);
	}
	
	 @PostMapping("/save")
       public Employeedto SaveOrUpdatEmployee(@RequestBody Employeedto dto) {
			return employeeService.SaveOrUpdatEmployee(dto);
	}
	 
	    @GetMapping("/byid/{idemp}")
		public Employeedto FindById(@PathVariable("idemp") Long id) throws EmployeeNotFound {
			return employeeService.FindById(id);
		}
	
	    
	    @GetMapping("/GetAllEmp")
		public List<Employeedto> ListAllEmployee() {
			return employeeService.ListAllEmployee();
		}
	    @GetMapping("/GetEmployeeByFullName/{fullName}")
	   	public List<Employeedto> ListByFullNmae(@PathVariable String fullName) {
	   		return employeeService.findByFullName(fullName);
	   	}

}
