package services;
import java.util.List;

import dto.Employeedto;
import exception.EmployeeNotFound;


public interface EmployService {
	public void deliteByIdy(Long id );
	public List<Employeedto> ListAllEmployee();
	public List<Employeedto> findByFullName(String LastName_FirstName);
	public Employeedto SaveOrUpdatEmployee(Employeedto dto);
	public Employeedto FindById(Long id) throws EmployeeNotFound;




}
