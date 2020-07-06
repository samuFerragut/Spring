package org.formacio.setmana2.repositori;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.formacio.setmana2.domini.Alumne;
import org.formacio.setmana2.domini.Curs;
import org.formacio.setmana2.domini.Matricula;
import org.springframework.stereotype.Repository;

/**
 * Modifica aquesta classe per tal que sigui un component Spring que realitza les 
 * operacions de persistencia tal com indiquen les firmes dels metodes
 */
@Repository
public class RepositoriEscola {
	
	@PersistenceContext
	private EntityManager em;

	
	public Curs carregaCurs(String nom) {		
		return em.find(Curs.class, nom);
	}
	

	public Matricula apunta (String alumne, String curs) throws EdatIncorrecteException {
	    	    
	    Alumne alumna = em.find(Alumne.class, alumne);
	    Curs curset = this.carregaCurs(curs);
	    
	    if (alumna == null || curset == null) {
				return null;
			}
	   
			Matricula matricula = new Matricula();

	    if (alumna.getEdat() >= curset.getEdatMinima()) {
				matricula.setAlumne(alumna);
				matricula.setCurs(curset);
				em.persist(matricula);
			} else {
				throw new EdatIncorrecteException();
			}
	    
	  	return matricula;   
	}
	
	
	
}
