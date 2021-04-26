

package tn.esprit.spring.service;



import static org.junit.Assert.assertEquals;

import java.text.ParseException;
import java.util.List;






import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


import tn.esprit.spring.entities.Employe;
import tn.esprit.spring.entities.Role;

import tn.esprit.spring.services.IEmployeService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EmployeServiceImplTest {
	
	
	@Autowired 
	IEmployeService us;
	
	Integer idEm;
	@Test
	public void testAddEmploye()  {
		
		Employe em = new Employe("najai", "mariem", "mariem@esprit.tn", "123456", Role.ADMINISTRATEUR); 
		Employe employeAdded = us.addEmploye(em); 
		assertEquals(em.getNom(),employeAdded.getNom());
	}
	
	@Test
	public void testRetrieveAllEmployes() {
		List<Employe> listEmployes = us.retrieveAllEmployes(); 
		 
		assertEquals(1, listEmployes.size());
	}

	@Test
	public void testModifyUser() throws ParseException   {
		
		Employe u = new Employe("najai", "mariem", "mariem@esprit.tn","12345", Role.INGENIEUR); 
		Employe userUpdated  = us.updateEmploye(u); 
		assertEquals(u.getPrenom(), userUpdated.getPrenom());
	}
	
	@Test
	public void testGetEmployeById() {
		Employe e =us.getEmployeeById(7);
		assertEquals(7, e.getId());
	}
	
	@Test
	public void testDeleteEmployeById()
	{
		if(idEm!=null){
		int i = us.deleteEmployeById(idEm);
		
		assertEquals(0, i);}
		else {
			int i = us.deleteEmployeById(7);
			
			assertEquals(0, i);}
	}
//mariem	
}
