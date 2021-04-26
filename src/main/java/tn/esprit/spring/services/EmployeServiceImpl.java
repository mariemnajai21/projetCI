package tn.esprit.spring.services;


import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



import tn.esprit.spring.entities.Employe;


import tn.esprit.spring.repository.EmployeRepository;





@Service
public class EmployeServiceImpl implements IEmployeService {
	@Autowired
	EmployeRepository emRepo;
	
	private static final Logger l = LogManager.getLogger(EmployeServiceImpl.class);

	
	

	@Override
	public int deleteEmployeById(int employeId)
	{
		l.debug("methode deleteEmployeById ");
		
		try {
		Employe employe = emRepo.findById(employeId).orElse(null);

		emRepo.delete(employe);
		return -1;}
		catch (Exception e) {
			l.error("erreur methode deleteEmpolyeById : " +e);
			return 0;
		}}	

	@Override
	public Employe updateEmploye(Employe em) {
		l.info("In  addEmploye : " + em);
		
		
		l.info("Out of  addEmploye. ");
		return emRepo.save(em);
	}

	@Override
	public Employe addEmploye(Employe em) {
		l.info("In  addEmploye : " + em); 
		Employe emSaved = emRepo.save(em);
		l.info("Out of  addEmploye. "); 
		return emSaved; 
	}

	@Override
	public List<Employe> retrieveAllEmployes() {
		List<Employe> employes = null;
		try{
		l.info("In  retrieveAllEmployes : "); 
		 employes = (List<Employe>) emRepo.findAll();
		for (Employe employe : employes) {
			l.debug("employe +++ : " +employe);
		}
		l.info("Out of retrieveAllUsers.");
		
		}catch (Exception e){
			l.error("Error in retrieveAllEmployes() : " + e);
		}
		return employes;
	}

	

	@Override
	public Employe getEmployeeById(int employeId) {
		l.debug("methode getEmployeById ");
		
			Employe et= emRepo.findById(employeId).orElse(null);
			l.debug("getEmployeById fini avec succes ");
			return et;
		
		}
		
	}

	


