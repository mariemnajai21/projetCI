
package tn.esprit.spring;



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
	
	
	@Test
	public void testAddEmploye()  {
		
		Employe em = new Employe("gaied", "med", "gaied@esprit.tn", "123456", Role.ADMINISTRATEUR); 
		Employe employeAdded = us.addEmploye(em); 
		assertEquals(em.getPrenom(),employeAdded.getNom());
	}
	
	@Test
	public void testRetrieveAllEmployes() {
		List<Employe> listEmployes = us.retrieveAllEmployes(); 
		 
		assertEquals(4, listEmployes.size());
	}

	@Test
	public void testModifyUser() throws ParseException   {
		
		Employe u = new Employe("gaied", "mohamed","test@esprit.tn","12345", Role.INGENIEUR); 
		Employe userUpdated  = us.updateEmploye(u); 
		assertEquals(u.getNom(), userUpdated.getPrenom());
	}
		
	
}
    

