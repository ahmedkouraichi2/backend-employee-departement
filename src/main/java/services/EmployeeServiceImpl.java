package services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dto.Employeedto;
import entity.Employee;
import exception.EmployeeNotFound;
import repository.EmplyoeeRepository;

@Service
public class EmployeeServiceImpl implements EmployService{

	@Autowired
	private EmplyoeeRepository emplyoeeRepository;
	@Override
	public void deliteByIdy(Long id) {
	
		emplyoeeRepository.deleteById(id);
		
	}

	@Override
	public List<Employeedto> ListAllEmployee() {
		List<Employee> employees = emplyoeeRepository.findAll();
		List<Employeedto> employeedtos = employees.stream().map(emp->Employeedto.FromEntity(emp)).collect(Collectors.toList()); 
		return employeedtos;
	}

	@Override
	public List<Employeedto> findByFullName(String LastName_FirstName) {
			// TODO Auto-generated method stub
			List<Employee> employees = emplyoeeRepository.getFullName(LastName_FirstName);
			List<Employeedto> employeedtos = employees.stream().map(emp->Employeedto.FromEntity(emp)).collect(Collectors.toList()); 
			return employeedtos;
		}
	

	@Override
	public Employeedto SaveOrUpdatEmployee(Employeedto dto) {
		Employee emp =  Employeedto.toEntity(dto);
		Employee empsavet = emplyoeeRepository.save(emp);
		Employeedto empdto = Employeedto.FromEntity(empsavet);
		return empdto;
	}

	@Override
	public Employeedto FindById(Long id) throws EmployeeNotFound {
		// TODO Auto-generated method stub
		Employee emp = emplyoeeRepository.findById(id).orElseThrow(()-> new EmployeeNotFound("EmployeeNexistepas"));
		Employeedto empdto = Employeedto.FromEntity(emp);
		return empdto;
     
	}

}
