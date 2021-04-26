package tn.esprit.spring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


import tn.esprit.spring.entities.Employe;

import tn.esprit.spring.entities.Role;


@Repository
public interface EmployeRepository extends CrudRepository<Employe, Integer>  {

	
	@Query("SELECT u FROM Employe u WHERE u.role= :role")
	List<Employe> retrieveEmployesByRole(@Param("role") Role role);
	
	
	@Modifying
	@Query("update Employe u set u.role = :role where u.nom = :fname")
	int updateEmployeStatusByNOM(@Param("role") Role role, @Param("fname") String
	fname);
	
	
	@Modifying
	@Query("DELETE FROM Employe u WHERE u.role = :role AND u.nom = :fname")
	int deleteEmployeByStatusAndNom(@Param("role") Role role, @Param("fname")
	String fname);
	
	
	
	@Modifying
	@Query(value = "INSERT INTO Employe (nom, prenom, role) VALUES (:fn, :ln,:role)", nativeQuery = true)
	void insertEmploye(@Param("fn") String fn, @Param("ln") String ln, @Param("role") Role role);
	

	
	
	
	
}
