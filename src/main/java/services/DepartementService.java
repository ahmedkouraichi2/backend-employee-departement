package services;

import java.util.List;

import dto.Departementdto;
import exception.DepartementNotFindException;

public interface DepartementService {
  
	public void deliteByIdy(Long id );
	public Departementdto SaveOrUpdatDepartement(Departementdto dto);
	public Departementdto FindById(Long id) throws DepartementNotFindException;
	public List<Departementdto> ListAllDepartement();
}
