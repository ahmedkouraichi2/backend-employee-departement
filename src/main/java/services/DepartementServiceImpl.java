package services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dto.Departementdto;
import entity.Departement;
import exception.DepartementNotFindException;
import exception.EmployeeNotFound;
import repository.DepartementRepository;

@Service
public class DepartementServiceImpl implements  DepartementService{
	 @Autowired
	 private DepartementRepository departementRepository; 
	
	@Override
	public void deliteByIdy(Long id) {
		// TODO Auto-generated method stub
		departementRepository.deleteById(id);
		
	}

	@Override
	public Departementdto SaveOrUpdatDepartement(Departementdto dto) {
		// TODO Auto-generated method stub
		Departement dpt = departementRepository.save(Departementdto.toEntity(dto));
		return Departementdto.FromEntity(dpt);
	}

	@Override
	public Departementdto FindById(Long id) throws DepartementNotFindException {
		// TODO Auto-generated method stub
		return 	Departementdto.FromEntity(departementRepository.findById(id).get());
		
	}

	@Override
	public List<Departementdto> ListAllDepartement() {
		List<Departement> departments = departementRepository.findAll();
		return departments.stream().map(dpt->Departementdto.FromEntity(dpt)).collect(Collectors.toList());
	}
	
	

}
