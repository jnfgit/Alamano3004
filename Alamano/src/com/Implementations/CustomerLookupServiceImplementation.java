package com.Implementations;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.persistence.Usuario;
import com.types.ICustomerLookupService;

import db.admin.DataBaseHelper;

public class CustomerLookupServiceImplementation implements ICustomerLookupService {

	@Override
	public Usuario findCustomer(String userName, String password) {
		
		EntityManagerFactory emf = 	Persistence.createEntityManagerFactory("prueba", new HashMap());
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
				
		Usuario usuario = null;
	
		Query queryCinco = em.createQuery("SELECT u FROM Usuario u Where u.email = :email and u.clave_pass = :clave_pass");
		queryCinco.setParameter("email", userName);
		
		DataBaseHelper hel = new DataBaseHelper();
		String pass = hel.getSHA1FromPassword(password);
		queryCinco.setParameter("clave_pass", pass);
		
		List usuarios = (ArrayList)queryCinco.getResultList();
		
		if(usuarios != null && usuarios.size() > 0){
			usuario = (Usuario)usuarios.get(0);
		}
				
		em.close();
		emf.close();
		
		return usuario;
	}
}
