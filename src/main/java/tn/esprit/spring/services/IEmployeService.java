package tn.esprit.spring.services;


import java.util.List;


import tn.esprit.spring.entities.Employe;

import tn.esprit.spring.entities.Role;




public interface IEmployeService {
	
	
	public String getEmployePrenomById(int employeId);
	public void deleteEmployeById(int employeId);
	 public Employe updateEmploye(Employe em);
	 public Employe addEmploye(Employe em);
	 public List<Employe> retrieveAllEmployes();
	 public List<Employe> retrieveEmployesByRole(Role role);
	
	

	
}
